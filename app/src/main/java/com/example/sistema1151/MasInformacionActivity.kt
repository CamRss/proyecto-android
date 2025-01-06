package com.example.sistema1151

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sistema1151.ui.theme.Sistema1151Theme


class MasInformacionActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sistema1151Theme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(text = stringResource(id = R.string.title_activity_mas_informacion)) },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.tertiary
                        ),
                        navigationIcon = {
                            IconButton(onClick = {
                                finish()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {
                                startActivity(
                                    Intent(
                                        this@MasInformacionActivity,
                                        TerminosActivity::class.java
                                    )
                                )
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Info, contentDescription = null
                                )
                            }
                        }
                    )
                }) {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(vertical = 10.dp, horizontal = 15.dp)
                    ) {
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_1),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 1", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_2),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 2", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_3),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 3", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_4),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 4", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_5),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 5", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_6),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 6", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_7),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 7", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Card {
                            Image(
                                painter = painterResource(id = R.drawable.compras_8),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f),
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier.padding(all = 16.dp)) {
                                Text(text = "Compra 8", style = MaterialTheme.typography.titleMedium)
                                Text(text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at ultricies mi, eget porta tortor. Aenean euismod nibh urna, ut ornare libero posuere vitae. Praesent dignissim nunc nulla.")
                            }

                        }
                    }
                }
            }
        }
    }
}

