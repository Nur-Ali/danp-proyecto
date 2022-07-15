package com.danp.proyecto_01.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.danp.proyecto_01.BottomBarScreen

const val maxLength = 6

fun navigateToDetails(navController: NavHostController, license: String, context: Context) {
    if (license.length == maxLength) {
        navController.navigate(BottomBarScreen.Products.route + "/$license")
    } else {
        Toast.makeText(context, "La matricula debe ser de 6 digitos", Toast.LENGTH_LONG).show()
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var license by remember {
            mutableStateOf("")
        }
        val pattern = remember { Regex("^[a-zA-Z0-9]*$") }
        val context = LocalContext.current
        Text(
            text = "FoodBudget",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF093980),
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://st2.depositphotos.com/1177973/8007/i/950/depositphotos_80072000-stock-photo-paper-bag-with-food.jpg"),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                )
        }
        Text(
            text = "Bienvenido",
            color =  Color(0xFF60708F)               ,
            style = MaterialTheme.typography.subtitle2,
            fontSize = MaterialTheme.typography.h5.fontSize,
        )

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}