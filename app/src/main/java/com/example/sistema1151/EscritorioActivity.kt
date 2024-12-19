package com.example.sistema1151

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sistema1151.paginas.AreaClientesActivity
import com.example.sistema1151.paginas.cajas.CajaActivity
import com.example.sistema1151.paginas.directores.DirectoresActivity
import com.example.sistema1151.paginas.EmpleadosActivity
import com.example.sistema1151.paginas.ProveedoresActivity
import com.example.sistema1151.paginas.TiendaActivity
import com.example.sistema1151.ui.theme.Sistema1151Theme

class EscritorioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val etiquetas =
            arrayOf("Proveedores", "Empleados", "Tienda", "Directores", "Area clientes", "Caja", "Salir")
        val iconos = intArrayOf(
            R.drawable.baseline_support_24, R.drawable.baseline_people_24,
            R.drawable.baseline_store_24, R.drawable.baseline_movie_24,
            R.drawable.baseline_person_24,
            R.drawable.baseline_money_24, R.drawable.baseline_logout_24
        )
        setContent {
            Sistema1151Theme {
                Column {
                    Box {
                        AsyncImage(
                            model = "https://static-basket-02.wb.ru/vol25/wbkids_articles_editor/6fe7da3e-6a0d-4d15-960e-1112675efb3a.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Surface(
                            color = Color.Black.copy(alpha = 0.7f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomStart)
                        ) {
                            Text(
                                text = stringResource(id = R.string.title_activity_escritorio),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                modifier = Modifier.padding(
                                    horizontal = dimensionResource(id = R.dimen.espacio1),
                                    vertical = 8.dp
                                )
                            )
                        }
                    }
                    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                        items(etiquetas.size) { posicion ->
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.tertiary
                                ),
                                modifier = Modifier
                                    .padding(all = dimensionResource(id = R.dimen.espacio2))
                                    .clickable {
                                        mostrarVentana(posicion)
                                    }
                            ) {
                                Icon(
                                    painter = painterResource(id = iconos[posicion]),
                                    contentDescription = null,
                                    modifier = Modifier.padding(
                                        top = dimensionResource(id = R.dimen.espacio1),
                                        start = dimensionResource(id = R.dimen.espacio1)
                                    )
                                )
                                Text(
                                    text = etiquetas[posicion],
                                    modifier = Modifier.padding(all = dimensionResource(id = R.dimen.espacio1))
                                )
                            }
                        }
                    })//LazyVerticalGrid
                }
            }
        }
    }

    private fun mostrarVentana(posicion: Int) {
        Log.d("PRUEBA", posicion.toString())
        when (posicion) {
            0 -> startActivity(Intent(this@EscritorioActivity, ProveedoresActivity::class.java))
            1 -> startActivity(Intent(this@EscritorioActivity, EmpleadosActivity::class.java))
            2 -> startActivity(Intent(this@EscritorioActivity, TiendaActivity::class.java))
            3 -> startActivity(Intent(this@EscritorioActivity, DirectoresActivity::class.java))
            4 -> startActivity(Intent(this@EscritorioActivity, AreaClientesActivity::class.java))
            5 -> startActivity(Intent(this@EscritorioActivity, CajaActivity::class.java))
            6 -> finish()

        }
    }
}
