package com.example.sistema1151.paginas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistema1151.R
import com.example.sistema1151.components.DibujarProveedor
import com.example.sistema1151.ui.theme.Sistema1151Theme
import com.example.sistema1151.utils.Total
import org.json.JSONArray

class ProveedoresActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leerServicio();

    }//onCreate

    private fun leerServicio() {
        val queue = Volley.newRequestQueue(this)
        val url =  Total.rutaServicio + "proveedores.php"
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
            val nombreempresa = jsonArray.getJSONObject(i).getString("nombreempresa")
            val nombrecontacto = jsonArray.getJSONObject(i).getString("nombrecontacto")
            val cargocontacto = jsonArray.getJSONObject(i).getString("cargocontacto")
            val map = HashMap<String, String>();
            map.put("nombreempresa", nombreempresa)
            map.put("nombrecontacto", nombrecontacto)
            map.put("cargocontacto", cargocontacto)
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
                        title = {   Text(text = stringResource(id = R.string.title_activity_proveedores)) },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            items(items = arrayList, itemContent = { proveedor ->
                                DibujarProveedor(proveedor)
                            })//items

                        })//LazyColumn

                }//Column
            }//SetContent
        }//Dibujar

    }//Class
}//Sistematheme

