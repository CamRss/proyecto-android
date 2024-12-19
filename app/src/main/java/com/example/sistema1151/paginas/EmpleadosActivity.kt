package com.example.sistema1151.paginas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistema1151.ui.theme.Sistema1151Theme
import com.example.sistema1151.utils.Total
import org.json.JSONArray

class EmpleadosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leerServicio();
        setContent {
            Sistema1151Theme {
            }
        }
    }//onCreate

    private fun leerServicio() {
        val queue = Volley.newRequestQueue(this)
        val url =  Total.rutaServicio + "empleados.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                Log.d("DATOS", response)
                llenarLista(response)
            },

            {
                Log.d("DATOSERROR", it.message.toString())
            })

        queue.add(stringRequest)
    }//leerServicio

    private fun llenarLista(response: String?) {
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>()
        for (i in 0 until jsonArray.length()) {
            val apellidos = jsonArray.getJSONObject(i).getString("apellidos")
            val nombres = jsonArray.getJSONObject(i).getString("nombres")
            val cargo = jsonArray.getJSONObject(i).getString("cargo")
            val foto = jsonArray.getJSONObject(i).getString("foto")
            val map = HashMap<String, String>();
            map.put("apellidos", apellidos)
            map.put("nombres", nombres)
            map.put("cargo", cargo)
            map.put("foto", foto)
            arrayList.add(map)
        }//for
        dibujar(arrayList)
    }//lenarLista

    private fun dibujar(arrayList: ArrayList<HashMap<String, String>>) {
        setContent {
                LazyRow(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        items(items = arrayList, itemContent = {empleado ->
                           Box(
                                modifier = Modifier.fillParentMaxSize()
                            ) {
                                DibujarEmpleado(empleado)
                            }//Box
                        })

                    })//LazyRown
        }//setContent
    }//llenarlista
}//class


@Composable
fun DibujarEmpleado(empleado: java.util.HashMap<String, String>) {
    AsyncImage(
        model = Total.rutaServicio + "fotos/" + empleado["foto"],
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 15.dp, bottom = 15.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ){
        Text(
            text = empleado["nombres"].toString() + " " + empleado["apellidos"].toString(),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 10.dp, vertical = 5.dp)
        )
        Text(
            text = empleado["cargo"].toString(),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .background(Color.Black)
                .padding(horizontal = 10.dp, vertical = 5.dp),
            color = Color.White
        )

    }//Column
}



