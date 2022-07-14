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

    object Details : BottomBarScreen(
        route = "details",
        title = "Details",
        icon = Icons.Default.Description
    )

    object Historial : BottomBarScreen(
        route = "historial",
        title = "Historial",
        icon = Icons.Default.History
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