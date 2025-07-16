package com.example.newsapplication

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapplication.ui.view.LoginScreen
import com.example.newsapplication.ui.view.home.HomePage
import com.example.newsapplication.ui.view.home.ProductListScreen

@Composable
fun RouteNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.loginScreen, builder = {
            composable(Routes.loginScreen) {
                LoginScreen(navController)
            }
            composable(Routes.HomeScreen) {
                HomePage()
            }
        })
}