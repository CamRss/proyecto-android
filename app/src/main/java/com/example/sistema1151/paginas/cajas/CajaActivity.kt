package com.example.sistema1151.paginas.cajas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sistema1151.paginas.directores.DirectoresInsertActivity
import com.example.sistema1151.ui.theme.Sistema1151Theme

class CajaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         Box(
             modifier = Modifier.fillMaxSize()
         ) {
             FloatingActionButton(
                 onClick = {
                     startActivity(
                         Intent(
                             this@CajaActivity,
                             CajaInsertActivity::class.java
                         )
                     )
                 }, modifier = Modifier
                     .padding(all = 20.dp)
                     .align(Alignment.BottomEnd)
             ) {
                 Icon(Icons.Filled.Add, contentDescription = null)
             }
         }
         }
    }
}

