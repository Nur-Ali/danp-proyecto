package com.danp.proyecto_01.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailsScreen(license: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),
        ) {
        Placa(license)
    }
}

@Composable
@Preview
fun DetailsScreenPreview() {
    DetailsScreen("")
}

@Composable
fun Placa(license: String?) {
    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),

        ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = "Resultado",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF093980),
                textAlign = TextAlign.Center
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Card(
                elevation = 10.dp,
                modifier =
                Modifier
                    .padding(10.dp)
                    .height(70.dp)
                    .width(300.dp)
                ,
                border = BorderStroke(1.dp, Color.Black),
            ) {
                if (license != null) {
                    Text(
                        text = license,
                        fontSize = MaterialTheme.typography.h3.fontSize,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF60708F)

                    )
                }

            }
        }


        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Descripcion",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp),
                color = Color(0xFF1873B9)
            )
            Text(
                text = "NISSAN AD VAN",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                ),
        ) {
            Text(
                text = "Año",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp),
                color = Color(0xFF1873B9)
            )
            Text(
                text = "2003",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Uso",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp),
                color = Color(0xFF1873B9)
            )
            Text(
                text = "Taxi",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Marca",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp),
                color = Color(0xFF1873B9)
            )
            Text(
                text = "NISSAN",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Modelo",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp),
                color = Color(0xFF1873B9)
            )
            Text(
                text = "AD VAN",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "VIN",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp),
                color = Color(0xFF1873B9)
            )
            Text(
                text = "VFY14598562",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://imagenes.km77.com/fotos/bbtcontent/clippingnew/KM7KPH20100429_0429/big.jpg"),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape),

                )
        }
    }
}