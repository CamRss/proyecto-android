package com.example.sistema1151

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistema1151.ui.theme.Sistema1151Theme
import org.json.JSONArray

class SociosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leerServicio()
        setContent {
            Sistema1151Theme {

            }
        }
    }

    private fun leerServicio() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://servicios.campus.pe/proveedores.php"
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
    }
    private fun llenarLista(response: String?) {
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>()
        for (i in 0 until jsonArray.length()) {
            val idproveedor = jsonArray.getJSONObject(i).getString("idproveedor")
            val nombreempresa = jsonArray.getJSONObject(i).getString("nombreempresa")
            val nombrecontacto = jsonArray.getJSONObject(i).getString("nombrecontacto")
            val cargocontacto = jsonArray.getJSONObject(i).getString("cargocontacto")
            val direccion = jsonArray.getJSONObject(i).getString("direccion")
            val ciudad = jsonArray.getJSONObject(i).getString("ciudad")
            val region = jsonArray.getJSONObject(i).getString("region")
            val codigopostal = jsonArray.getJSONObject(i).getString("codigopostal")
            val pais = jsonArray.getJSONObject(i).getString("pais")
            val telefono = jsonArray.getJSONObject(i).getString("telefono")
            val fax = jsonArray.getJSONObject(i).getString("fax")


            val map = HashMap<String, String>();
            map.put("idproveedor", idproveedor)
            map.put("nombreempresa", nombreempresa)
            map.put("nombrecontacto", nombrecontacto)
            map.put("cargocontacto", cargocontacto)
            map.put("direccion", direccion)
            map.put("ciudad", ciudad)

            if(region == "null" ) {
                map.put("region", "Sin region")
            } else {
                map.put("region", region)
            }

            map.put("codigopostal", codigopostal)
            map.put("pais", pais)
            map.put("telefono", telefono)

            if(fax == "null" ) {
                map.put("fax", "Sin fax")
            } else {
                map.put("fax", fax)
            }

            arrayList.add(map)
        }//for
       dibujar(arrayList)
    }//lenarLista

    @OptIn(ExperimentalMaterial3Api::class)
    private fun dibujar(arrayList: ArrayList<HashMap<String, String>>) {
        setContent {
            Sistema1151Theme {
                Column {
                TopAppBar(
                    title = {   Text(text = stringResource(id = R.string.title_activity_socios)) },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer

                        )
                    )
                    LazyRow(
                        modifier = Modifier.fillMaxSize(),

                        content = {
                            items(items = arrayList, itemContent = { socios ->
                                Column(
                                    modifier = Modifier
                                        .padding(all = dimensionResource(id = R.dimen.espacio2))
                                        .border(
                                            width = 1.dp,
                                            color = Color.Gray,
                                            shape =  RoundedCornerShape(16.dp)
                                        )
                                        .padding(all = dimensionResource(id = R.dimen.espacio))
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = socios["idproveedor"].toString(),
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.Blue,
                                        fontStyle = FontStyle.Italic,
                                    )
                                    Text(
                                        text = socios["nombreempresa"].toString(),
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.Blue,
                                        fontStyle = FontStyle.Italic,
                                    )

                                    Text(
                                        text = socios["nombrecontacto"].toString(),
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    Text(text = socios["cargocontacto"].toString(),
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.Blue
                                    )
                                    Text(
                                        text = socios["direccion"].toString(),
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                    Text(
                                        text = socios["ciudad"].toString(),
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                    Text(
                                        text = socios["region"]?.toString() ?: "Sin region",
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                    Text(
                                        text = socios["codigopostal"].toString(),
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                    Text(
                                        text = socios["pais"].toString(),
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                    Text(
                                        text = socios["telefono"].toString(),
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                    Text(
                                        text = socios["fax"]?.toString() ?: "Sin fax",
                                        style = MaterialTheme.typography.titleMedium,

                                    )
                                }
                            })//items

                        })//LazyColumn

                }//Column
            }//SetContent
        }//Dibujar


    }//Class


}

