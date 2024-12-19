package com.example.sistema1151.paginas

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.sistema1151.SplashActivity
import com.example.sistema1151.paginas.ui.theme.Sistema1151Theme
import com.example.sistema1151.utils.Total
import com.example.sistema1151.utils.UserStore
import kotlinx.coroutines.launch

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var mostrarVentanaAlert by remember { mutableStateOf(false) }
            Column (modifier = Modifier.padding(24.dp)){

                Text(text = Total.usuarioActivo.getString("nombres"),
                     style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 36.sp)
                )
                Text(text = Total.usuarioActivo.getString("cargo"))
                Text(text = Total.usuarioActivo.getString("empresa"))
                Button(onClick = {
                    mostrarVentanaAlert = true
                }) {
                    Text(text = "Cerrar sesión")
                }
            }
            if (mostrarVentanaAlert) {
                AlertDialog(
                    icon = { Icon(Icons.Filled.Warning, contentDescription = null) },
                    title = { Text(text = "Cerrar sesión") },
                    text = { Text(text = "¿Está seguro que desea cerrar la sesión?") },
                    onDismissRequest = { /*TODO*/ },
                    confirmButton = {
                        Button(onClick = {
                            mostrarVentanaAlert = false
                            cerrarSesion()
                        }) {
                            Text(text = "Si")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { mostrarVentanaAlert = false }) {
                            Text(text = "No")
                        }
                    }
                )
            }
        }//setcontent
    }

    private fun cerrarSesion() {
        val userStore = UserStore(this)
        lifecycleScope.launch {
            userStore.setDatosUsuario("")
        }
        startActivity(Intent(this,SplashActivity::class.java))
    }
}