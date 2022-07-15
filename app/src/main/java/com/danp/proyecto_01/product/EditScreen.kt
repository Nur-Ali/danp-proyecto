package com.danp.proyecto_01.product

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danp.proyecto_01.data.Product
import com.danp.proyecto_01.data.ProductViewModel

@Composable
fun EditScreen(
    productId: String?,
    navController: NavController,
    productViewModel: ProductViewModel?,
    onSetAppTitle: (String) -> Unit,
    onShowFab: (Boolean) -> Unit,
    onProductEdited: (Product) -> Unit
) {
    LaunchedEffect(Unit) {
        onSetAppTitle("Editar Producto")
        onShowFab(false)
    }

    val receivedProduct: Product by productViewModel?.getProduct(productId!!.toInt())!!
        .observeAsState(Product(0, "", "","", "", "", "", "", "", "", "", ""))

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    val context = LocalContext.current

    if (receivedProduct.id != 0) {
        LaunchedEffect(Unit) {
            name = receivedProduct.productName
            description = receivedProduct.productDescription
            amount = receivedProduct.productAmount
            price = receivedProduct.productPrice
            type = receivedProduct.productType

        }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descripcion") },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Cantidad") },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Precio") },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Tipo") },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = {
                if (productViewModel!!.isItemValid(name, description, amount, price)) {
                    val updatedItem = receivedProduct.copy(
                        productName = name.trim(),
                        productDescription = description.trim(),
                        productAmount = amount.trim(),
                        productPrice = price.trim(),
                    )
                    onProductEdited(updatedItem)

                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                } else {
                    Toast.makeText(context, "Hay un campo vacio!!", Toast.LENGTH_LONG)
                }
            }, modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF093980))
        ) {
            Text(text = "Guardar",  color = Color.White)
        }
    }
}