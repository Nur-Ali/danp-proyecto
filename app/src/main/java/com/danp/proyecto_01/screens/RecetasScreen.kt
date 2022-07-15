package com.danp.proyecto_01.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.rememberAsyncImagePainter
import com.danp.proyecto_01.product.AddScreen
import com.danp.proyecto_01.product.EditScreen
import com.danp.proyecto_01.product.ProductDetailsScreen
import com.danp.proyecto_01.product.ProductListScreen

@Composable
fun MessageCard(receta: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {

        Spacer(modifier = Modifier.width(16.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) Color(0xFFF0F4FB) else Color.White,
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = receta.nombre,
                color =  Color(0xFF093980)               ,
                style = MaterialTheme.typography.subtitle2,
                fontSize = MaterialTheme.typography.h6.fontSize,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Dificultad",
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2,
                        color =  Color(0xFF093980),
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    Text(
                        text = receta.dificultad,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp)
                ) {
                    Text(
                        text = "Ingredientes",
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2,
                        color =  Color(0xFF093980),
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 72.dp)
                ) {
                    Text(
                        text = receta.descripcion,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }

            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de recetas", color = Color.White, textAlign = TextAlign.Center
                ) },
                backgroundColor = Color(0xFF093980),
            ) },

        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ){
                Row(modifier = Modifier.padding(bottom = 24.dp)) {
                    LazyColumn {
                        items(messages) { message ->
                            MessageCard(message)
                        }
                    }
                }

            }
        }
    )
}


@Composable
fun RecetaScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Recetas",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF093980),
        )
    }
}

@Composable
@Preview
fun RecetaScreenPreview() {
    Conversation(SampleData.recetas)
}

