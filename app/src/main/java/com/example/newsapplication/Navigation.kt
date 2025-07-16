package com.example.newsapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapplication.ui.view.LoginScreen
import com.example.newsapplication.ui.view.home.HomePage
import com.example.newsapplication.ui.view.productView.ItemDetailsScreen

@Composable
fun RouteNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.loginScreen, builder = {
            composable(Routes.loginScreen) {
                LoginScreen(navController)
            }
            composable(Routes.HomeScreen) {
                HomePage(navController)
            }
            composable(Routes.ProductDetailWithArgs) {
                backStackEntry -> val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                ItemDetailsScreen(productId)
            }
        })
}