package com.danp.proyecto_01

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Products : BottomBarScreen(
        route = "products",
        title = "Productos",
        icon = Icons.Default.ShoppingCart
    )

    object Recetas : BottomBarScreen(
        route = "recetas",
        title = "Recetas",
        icon = Icons.Default.Pageview
    )

    object Login : BottomBarScreen(
        route = "login",
        title = "login",
        icon = Icons.Default.History
    )

    object Register : BottomBarScreen(
        route = "register",
        title = "register",
        icon = Icons.Default.History
    )
}