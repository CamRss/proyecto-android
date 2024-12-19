package com.example.sistema1151.paginas.directores

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistema1151.utils.Total

@OptIn(ExperimentalMaterial3Api::class)
class DirectoresUpdateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras //para recuperar los datos que recibe este
        //activity con la clase Bundle
        val vIddirector = bundle!!.getString("iddirector").toString()
        val vNombres = bundle.getString("nombres").toString()
        val vPeliculas = bundle.getString("peliculas").toString()
        setContent {
            var iddirector by remember { mutableStateOf(vIddirector) }
            var nombres by remember { mutableStateOf(vNombres) }
            var peliculas by remember { mutableStateOf(vPeliculas) }

            Column(modifier = Modifier.padding(all = 32.dp)) {
                TextField(value = iddirector,
                    readOnly = true,
                    label = { Text(text = "Nombre del director") },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        iddirector = it
                    })

                Spacer(modifier = Modifier.size(16.dp))
                TextField(value = nombres,
                    label = { Text(text = "Nombre del director") },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        nombres = it
                    })

                Spacer(modifier = Modifier.size(16.dp))
                TextField(value = peliculas,
                    label = { Text(text = "Peliculas") },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        peliculas = it
                    })

                Spacer(modifier = Modifier.size(16.dp))
                Row {
                    Button(onClick = {
                        leerServicioActualizar(iddirector, nombres, peliculas)
                    }) {
                        Text(text = "Actualizar director")
                    }
                    Button(onClick = {
                        leerServicioEliminar(iddirector)
                    }) {
                        Text(text = "Eliminar")
                    }
                }

            }
        }
    }

    private fun leerServicioEliminar(iddirector: String) {
        val queue = Volley.newRequestQueue(this)
        val url = Total.rutaServicio + "directoresdelete.php"
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                Log.d("DATOS", response)
                Toast.makeText(this, "Eliminado" + response + "Registro", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, DirectoresActivity::class.java))
            },
            {
                Log.d("DATOSERROR", it.message.toString())
            }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params.put("iddirector", iddirector)
                return params
            }
        }

        queue.add(stringRequest)
    }


    private fun leerServicioActualizar(iddirector: String, nombres: String, peliculas: String) {

        val queue = Volley.newRequestQueue(this)
        val url = Total.rutaServicio + "directoresupdate.php"
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                Log.d("DATOS", response)
                Toast.makeText(this, "Actualizado" + response + "Registro", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, DirectoresActivity::class.java))
            },
            {
                Log.d("DATOSERROR", it.message.toString())
            }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params.put("iddirector", iddirector)
                params.put("nombres", nombres)
                params.put("peliculas", peliculas)
                return params
            }
        }

        queue.add(stringRequest)
    }

}

