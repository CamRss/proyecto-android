package com.example.sistema1151.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.sistema1151.R

@Composable
fun DibujarProveedor(proveedor: java.util.HashMap<String, String>) {
    Column(
        modifier = Modifier
            .padding(all = dimensionResource(id = R.dimen.espacio2))
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RectangleShape
            )
            .padding(all = dimensionResource(id = R.dimen.espacio))
            .fillMaxWidth()
    ) {
        Text(
            text = proveedor["nombreempresa"].toString(),
            style = MaterialTheme.typography.titleLarge,
            color = Color.Red
        )
        Text(
            text = proveedor["nombrecontacto"].toString(),
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = proveedor["cargocontacto"].toString())
    }
}