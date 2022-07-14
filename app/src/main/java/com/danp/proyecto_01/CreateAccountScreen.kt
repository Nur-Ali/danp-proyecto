package com.danp.proyecto_01

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.danp.proyecto_01.screens.maxLength
import com.danp.proyecto_01.screens.navigateToDetails

@Composable
fun CreateAccountScreen(
    onCreateAccount: (String, String) -> (Unit),
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var mail by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        val pattern = remember { Regex("^[a-zA-Z0-9]*$") }
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
                painter = rememberAsyncImagePainter("https://www.manualesdetodo.net/wp-content/uploads/2020/01/b8-1980-1536x782.png"),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
            )
        }

        OutlinedTextField(
            value = mail,
            placeholder = { Text(text = "Ingrese su email") },
            onValueChange = {
                mail = it
            },
            label = { Text(text = "Email") },
        )

        OutlinedTextField(
            value = password,
            placeholder = { Text(text = "Ingrese su contraseña") },
            onValueChange = {
                password = it
            },
            label = { Text(text = "Contraseña") },
        )

        Button(
            onClick = {
                onCreateAccount(mail, password)
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF093980))
        ) {
            Text(text = "Iniciar sesión",  color = Color.White)
        }
    }
}

