package com.example.sistema1151

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sistema1151.ui.theme.Sistema1151Theme

class TerminosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sistema1151Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(all = dimensionResource(id = R.dimen.espacio1))
                ) {
                    Text(
                        text = stringResource(id = R.string.title_activity_terminos),
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(text = stringResource(id = R.string.contenido_terminos))
                    Button(onClick = {
                        finish()
                    }, shape = MaterialTheme.shapes.large) {
                        Text(text = stringResource(id = R.string.cerrar))

                    }

                }

            }
        }
    }
}


