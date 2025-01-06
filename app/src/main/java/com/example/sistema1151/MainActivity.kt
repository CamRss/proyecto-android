package com.example.sistema1151

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.sistema1151.ui.theme.Sistema1151Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sistema1151Theme {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dimensionResource(id = R.dimen.espacio)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.mensaje),
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = stringResource(id = R.string.autor),
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = stringResource(id = R.string.logo)
                    )
                    Text(
                        text = stringResource(id = R.string.saludo),
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Button(onClick = {
                        startActivity(Intent(this@MainActivity, EmpezarActivity::class.java))
                    }, shape = MaterialTheme.shapes.large) {
                        Text(text = stringResource(id = R.string.inicio))
                    }

                    Button(onClick = {
                        startActivity(Intent(this@MainActivity, MasInformacionActivity::class.java))
                    }, shape = MaterialTheme.shapes.large) {
                        Text(text = stringResource(id = R.string.title_activity_mas_informacion))
                    }
                    Button(onClick = {
                        startActivity(Intent(this@MainActivity, SociosActivity::class.java))
                    }, shape = MaterialTheme.shapes.large) {
                        Text(text = stringResource(id = R.string.title_activity_socios))
                    }


                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(
                        text = stringResource(id = R.string.derechos),
                        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.espacio))
                    )
                }
            }

        }
    }
}


