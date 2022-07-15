package com.danp.proyecto_01.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danp.proyecto_01.data.Product
import com.danp.proyecto_01.data.ProductViewModel

@Composable
fun ProductDetailsScreen(
    productId: String?,
    navController: NavController,
    productViewModel: ProductViewModel,
    onSetAppTitle: (String) -> Unit,
    onShowFab: (Boolean) -> Unit,
    onCarDeleted: (Product) -> Unit
) {

    LaunchedEffect(Unit) {
        onSetAppTitle("Detalles del producto")
        onShowFab(false)
    }

    val receiverProduct = productViewModel.getProduct(productId!!.toInt()).observeAsState()
    val product = receiverProduct.value ?: Product(
        0, "", "","",
        "", "", "", "", "",
        "", "", "")

    val showDialog = remember { mutableStateOf(false) }
    val deleteConfirmed = remember { mutableStateOf(false) }

    if (showDialog.value) {
        ShowConfirmationDialog(
            title = "Eliminar producto?",
            text = "¿Esta seguro que desea eliminar este producto?",
            onResponse = {
                deleteConfirmed.value = it
                showDialog.value = false
            }
        )
    }

    if (deleteConfirmed.value) {
        onCarDeleted(product)
        navController.navigate("home") {
            popUpTo("home") { inclusive = true }
        }
        deleteConfirmed.value = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Nombre",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
                ,
                textAlign = TextAlign.End,
                color = Color(0xFF1873B9)
            )
            Text(
                text = product.productName,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                ),
        ) {
            Text(
                text = "Descripcion",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
                ,
                color = Color(0xFF1873B9)
            )
            Text(
                text = product.productDescription,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Cantidad",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
                ,
                color = Color(0xFF1873B9)
            )
            Text(
                text = product.productAmount,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Precio",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
                ,
                color = Color(0xFF1873B9)
            )
            Text(
                text = product.productPrice,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    end = 30.dp,
                    bottom = 15.dp,
                )
        ) {
            Text(
                text = "Tipo",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
                ,
                color = Color(0xFF1873B9)
            )
            Text(
                text = product.productType,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF60708F)

            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("edit/${product.id}") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF093980))

        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp).padding(bottom = 32.dp)

            )
            Text("Editar Producto", modifier = Modifier.padding(start = 8.dp), color = Color.White)
        }

        OutlinedButton(
            onClick = { showDialog.value = true },
            modifier = Modifier
                .padding(top = 16.dp, bottom = 32.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = null,
                tint = Color(0xFF093980),
                modifier = Modifier.size(16.dp)
            )
            Text("Eliminar producto", modifier = Modifier.padding(start = 8.dp), color = Color(0xFF093980) )
        }

    }
}

@Composable
fun ShowConfirmationDialog(title: String, text: String, onResponse: (Boolean) -> Unit) {
    AlertDialog(
        onDismissRequest = { onResponse(false) },
        title = { Text(title) },
        text = { Text(text) },
        confirmButton = {
            TextButton(onClick = { onResponse(true) }) {
                Text("Si", color = Color(0xFF093980))
            }
        },
        dismissButton = {
            TextButton(onClick = { onResponse(false) }) {
                Text("No", color = Color(0xFF093980))
            }
        }
    )
}