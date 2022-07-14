package com.danp.proyecto_01

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danp.proyecto_01.screens.*

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    startRoute: String,
    signIn: (String, String) -> (Unit),
    createAccount: (String, String) -> (Unit),
) {
    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Details.route) {
            DetailsScreen("NO DATA")
        }
        composable(route = BottomBarScreen.Details.route + "/{license}") {
            val license = it.arguments?.getString("license")
            DetailsScreen(license)
        }
        composable(route = BottomBarScreen.Historial.route) {
            Conversation(SampleData.autos)
        }
        composable(route = BottomBarScreen.Login.route) {
            LoginScreen(signIn, createAccount, navController)
        }
        composable(route = BottomBarScreen.Register.route) {
            CreateAccountScreen(createAccount, navController)
        }
    }
}
