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
import com.google.firebase.auth.FirebaseAuth


fun signOut(navController: NavHostController){
    FirebaseAuth.getInstance().signOut()
    navController.navigate("login")
}


@Composable
fun HomeScreen(navController: NavHostController) {
    val email = FirebaseAuth.getInstance().currentUser?.email;

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
            text = "Bienvenido $email",
            color =  Color(0xFF60708F)               ,
            style = MaterialTheme.typography.subtitle2,
            fontSize = MaterialTheme.typography.h5.fontSize,
        )

        Button(
            onClick = {
                signOut(navController)
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF093980))
        ) {
            Text(text = "Cerrar sesión",  color = Color.White)
        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}