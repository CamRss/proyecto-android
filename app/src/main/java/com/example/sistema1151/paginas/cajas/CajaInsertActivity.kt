package com.example.sistema1151.paginas.cajas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sistema1151.paginas.cajas.ui.theme.Sistema1151Theme

@OptIn(ExperimentalMaterial3Api::class)
class CajaInsertActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                var descripcion by remember { mutableStateOf("") }
                var monto by remember { mutableStateOf("") }
                Column(modifier = Modifier.padding(all = 32.dp)) {
                    TextField(value = descripcion,
                        label = { Text(text = "descripcion") },
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = {
                            descripcion = it
                        })
                    Spacer(modifier = Modifier.size(16.dp))
                    TextField(value = monto,
                        label = { Text(text = "monto") },
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = {
                            monto = it
                        })
                    Spacer(modifier = Modifier.size(16.dp))
                    Button(onClick = {
                    }) {
                        Text(text = "Registrar Movimiento")
                    }
                }
            }
        }
    }
}

