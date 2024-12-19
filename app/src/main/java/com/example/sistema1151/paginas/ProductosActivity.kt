package com.example.sistema1151.paginas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.sistema1151.R
import com.example.sistema1151.utils.Total
import org.json.JSONArray

class ProductosActivity : ComponentActivity() {
    var nombre = ""
    var descripcion = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras //para recuperar los datos que recibe este
        //activity con la clase Bundle
        val idcategoria = bundle!!.getString("idcategoria")
        this.nombre = bundle.getString("nombre").toString()
        this.descripcion = bundle.getString("descripcion").toString()
        Log.d("idcategoria", idcategoria.toString())

        leerServicio(idcategoria);

    }//onCreate


    private fun leerServicio(idcategoria: String?) {
        val queue = Volley.newRequestQueue(this)
        val url =  Total.rutaServicio + "productos.php?idcategoria=" + idcategoria
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
            val idproducto = jsonArray.getJSONObject(i).getString("idproducto")
            val nombre = jsonArray.getJSONObject(i).getString("nombre")
            val precio = jsonArray.getJSONObject(i).getString("precio")
            val imagenchica = jsonArray.getJSONObject(i).getString("imagenchica")
            val preciorebajado = jsonArray.getJSONObject(i).getString("preciorebajado")
            val map = HashMap<String, String>();
            map.put("idproducto", idproducto)
            map.put("nombre", nombre)
            map.put("precio", precio)
            map.put("imagenchica", imagenchica)
            map.put("preciorebajado", preciorebajado)
            arrayList.add(map)
        }
        dibujar(arrayList)
    }//llenarlista

    private fun dibujar(arrayList: ArrayList<HashMap<String, String>>) {
        setContent {
            Column {
                Text(
                    text = nombre!!,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(text = descripcion!!)
                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    items(arrayList.size) { posicion ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            modifier = Modifier
                                .padding(all = dimensionResource(id = R.dimen.espacio2))
                                .height(250.dp)
                                .shadow(
                                    elevation = dimensionResource(id = R.dimen.espacio2)
                                )
                                .clickable{
                                    seleccionarProducto(arrayList[posicion].get("idproducto").toString())
                                }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(all = dimensionResource(id = R.dimen.espacio1))
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                val precio: Float = arrayList[posicion].get("precio")!!.toFloat()
                                val preciorebajado: Float = arrayList[posicion].get("preciorebajado")!!.toFloat()
                                Box {
                                    if(arrayList[posicion].get("imagenchica").toString() == "null"){
                                        Image(painter = painterResource(id = R.drawable.nofoto), contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(150.dp))
                                    }
                                   else{
                                       AsyncImage(
                                            model = Total.rutaServicio + arrayList[posicion].get("imagenchica").toString(),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(150.dp)
                                        )
                                    }
                                    if(preciorebajado != 0f) {
                                        val descuento: Float = (1 - preciorebajado/precio) * 100;
                                         Text(
                                        text = String.format("%.0f" , descuento) + "%",
                                        modifier = Modifier
                                            .background(Color.Red)
                                            .padding(horizontal = 10.dp, vertical = 5.dp),
                                        color = Color.White
                                          )
                                     }
                                }
                                Text(
                                    text = arrayList[posicion].get("nombre").toString(),
                                    textAlign = TextAlign.Center

                                )
                                var precioVenta = 0f
                                if (preciorebajado == 0f) {
                                    precioVenta = precio
                                } else {
                                    precioVenta = preciorebajado
                                }
                                Text(
                                    text = "S/ " + String.format("%.2f", precioVenta)

                                )

                                if (preciorebajado != 0f){
                                Text(
                                    text = "S/ " + String.format("%.2f", precio),
                                    textDecoration = TextDecoration.LineThrough,
                                    color = Color.Gray

                                )
                            }
                        }

                        }
                    }
                })//LazyVerticalGrid
            }

        }//setContent
    }

    private fun seleccionarProducto(idproducto: String) {
        val bundle = Bundle().apply {
            putString("idproducto", idproducto)
        }
        val intent = Intent( this, ProductoDetalleActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}//class

