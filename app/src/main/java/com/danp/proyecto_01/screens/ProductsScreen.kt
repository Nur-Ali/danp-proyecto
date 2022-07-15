package com.danp.proyecto_01.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danp.proyecto_01.product.AddScreen
import com.danp.proyecto_01.product.EditScreen
import com.danp.proyecto_01.product.ProductDetailsScreen
import com.danp.proyecto_01.product.ProductListScreen
import com.danp.proyecto_01.data.Product
import com.danp.proyecto_01.data.ProductViewModel

@Composable
fun ProductsScreen(productViewModel: ProductViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),
    ) {
        ProductCRUD(
            productViewModel,
            onAddProduct = { productViewModel.addProduct(it) },
            onEditProduct = { productViewModel.updateProduct(it) },
            onDeleteProduct = { productViewModel.deleteProduct(it) }
        )
    }
}

@Composable
fun ProductCRUD(
    productViewModel: ProductViewModel,
    onAddProduct: (Product) -> Unit,
    onEditProduct: (Product) -> Unit,
    onDeleteProduct: (Product) -> Unit
) {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    var appTitle by remember { mutableStateOf("") }
    var showFab by remember { mutableStateOf(false) }

    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }

    val navigationIcon: (@Composable () -> Unit)? =
        if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        } else {
            null
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(appTitle, color = Color.White, textAlign = TextAlign.Center
                ) },
                navigationIcon = navigationIcon,
                backgroundColor = Color(0xFF093980),
            ) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            if (showFab) { // display FAB based on the even from screens
                FloatingActionButton(
                    modifier =
                    Modifier
                        .padding(bottom = 45.dp)
                    ,
                    onClick = { navController.navigate("add") },
                    backgroundColor = Color(0xFF093980)) {
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "Agregar Producto",
                        tint = Color.White
                    )
                }
            }
        },
        content = {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    ProductListScreen(
                        navController,
                        productViewModel,
                        onSetAppTitle = { appTitle = it },
                        onShowFab = { showFab = it }
                    )
                }
                composable("details/{itemId}") { backStackEntry ->
                    ProductDetailsScreen(
                        backStackEntry.arguments?.getString("itemId"),
                        navController,
                        productViewModel,
                        onSetAppTitle = { appTitle = it },
                        onShowFab = { showFab = it },
                        onCarDeleted = { onDeleteProduct(it) }
                    )
                }
                composable("add") {
                    AddScreen(
                        navController,
                        productViewModel,
                        onSetAppTitle = { appTitle = it },
                        onShowFab = { showFab = it },
                        onCarAdded = { onAddProduct(it) }
                    )
                }
                composable("edit/{itemId}") { backStackEntry ->
                    EditScreen(
                        backStackEntry.arguments?.getString("itemId"),
                        navController,
                        productViewModel,
                        onSetAppTitle = { appTitle = it },
                        onShowFab = { showFab = it },
                        onProductEdited = { onEditProduct(it) }
                    )
                }
            }
        }
    )
}

