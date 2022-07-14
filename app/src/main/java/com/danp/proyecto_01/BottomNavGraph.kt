package com.danp.proyecto_01

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danp.proyecto_01.data.ProductViewModel
import com.danp.proyecto_01.screens.*

@Composable
fun BottomNavGraph(
    productViewModel: ProductViewModel,
    navController: NavHostController,
    startRoute: String,
    signIn: (String, String, ProductViewModel) -> (Unit),
    createAccount: (String, String, ProductViewModel) -> (Unit),
) {
    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Products.route) {
            ProductsScreen(productViewModel)
        }

        composable(route = BottomBarScreen.Historial.route) {
            Conversation(SampleData.autos)
        }
        composable(route = BottomBarScreen.Login.route) {
            LoginScreen(signIn, createAccount, navController, productViewModel)
        }
        composable(route = BottomBarScreen.Register.route) {
            CreateAccountScreen(createAccount, navController, productViewModel)
        }
    }
}
