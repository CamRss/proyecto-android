package com.example.sistema1151.paginas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistema1151.R
import com.example.sistema1151.ui.theme.Sistema1151Theme
import com.example.sistema1151.utils.Total
import org.json.JSONArray

class TiendaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leerServicio();

    }//onCreate

    private fun leerServicio() {
        val queue = Volley.newRequestQueue(this)
        val url =  Total.rutaServicio + "categorias.php"
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
    }//leerservicio

    private fun llenarLista(response: String?) {
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>()
        for (i in 0 until jsonArray.length()) {
            val idcategoria = jsonArray.getJSONObject(i).getString("idcategoria")
            val nombre = jsonArray.getJSONObject(i).getString("nombre")
            val descripcion = jsonArray.getJSONObject(i).getString("descripcion")
            val total = jsonArray.getJSONObject(i).getString("total")
            val map = HashMap<String, String>();
            map.put("idcategoria", idcategoria)
            map.put("nombre", nombre)
            map.put("descripcion", descripcion)
            map.put("total", total)
            arrayList.add(map)
        }
        dibujar(arrayList)
    }//llenarlista

    @OptIn(ExperimentalMaterial3Api::class)
    private fun dibujar(arrayList: ArrayList<HashMap<String, String>>) {
        setContent {
            Sistema1151Theme {
                Column {
                    TopAppBar(
                        title = {   Text(text = stringResource(id = R.string.title_activity_tienda)) },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    )
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            items(items = arrayList, itemContent = { categoria ->
                                Card(
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0, 250, 200, 255)
                                    ),
                                    modifier = Modifier
                                        .padding(all = dimensionResource(id = R.dimen.espacio2))
                                        .fillMaxWidth()
                                        .clickable {
                                            seleccionarCategoria(categoria)
                                        }
                                ) {
                                    Column(
                                        modifier = Modifier.padding(all = dimensionResource(id = R.dimen.espacio))
                                    ) {
                                        Text(
                                            text = categoria["nombre"].toString(),
                                            style = MaterialTheme.typography.titleLarge,
                                            color = Color.Red
                                        )
                                        Text(
                                            text = categoria["descripcion"].toString(),
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                        Text(
                                            text = stringResource(id = R.string.cantidad_productos) +
                                                    categoria["total"].toString()
                                        )
                                    }//column

                                }//card
                            })//items

                        })//LazyColumn

                }//Column
            }//SetContent
        }//Dibujar
    }//Sistematheme

    private fun seleccionarCategoria(categoria: HashMap<String, String>) {
        val idcategoria = categoria["idcategoria"]
        val nombre = categoria["nombre"]
        val descripcion = categoria["descripcion"]
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        val bundle = Bundle().apply {
            putString("idcategoria", idcategoria)
            putString("nombre", nombre)
            putString("descripcion", descripcion)
        }
        val intent = Intent( this, ProductosActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }//SeleccionarCategoria}

}//Class





