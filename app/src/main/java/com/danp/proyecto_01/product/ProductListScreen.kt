package com.danp.proyecto_01.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danp.proyecto_01.data.Product
import com.danp.proyecto_01.data.ProductViewModel


@Composable
fun ProductListScreen(
    navController: NavController,
    productViewModel: ProductViewModel,
    onSetAppTitle: (String) -> Unit,
    onShowFab: (Boolean) -> Unit
) {
    val cars: List<Product> by productViewModel.allProducts.observeAsState(listOf())

    LaunchedEffect(Unit) {
        onSetAppTitle("Lista de productos")
        onShowFab(true)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            item { ItemHeaderLayout() }

            items(cars) { car ->
                ItemLayout(car, navController)
            }
        }
    }
}

@Composable
fun ItemHeaderLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF093980))
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Producto",
            modifier = Modifier.weight(1f),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Precio",
            modifier = Modifier.weight(1f),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Cantidad",
            modifier = Modifier.weight(1f),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ItemLayout(product: Product, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F4FB))
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { navController.navigate("details/${product.id}") }

    ) {
        Text(product.productName, modifier = Modifier.weight(1f), color = Color(0xFF1873B9) )
        Text(product.productPrice, modifier = Modifier.weight(1f), color = Color(0xFF1873B9) )
        Text(product.productAmount, modifier = Modifier.weight(1f), color = Color(0xFF1873B9) )
    }
}
