package com.example.newsapplication.ui.view.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.newsapplication.ui.components.AppBar

@Composable
fun HomePage(navController: NavController) {

    Scaffold(
        topBar = {
            AppBar(
                "Products",
                navController = navController,
                showBackButton = false,
                showCartButton = true
            )
        },
//        bottomBar = { BottomNavBar(navController = navController) }

    ) { innerPadding ->
        ProductListScreen(
            navController,
            paddingValues = innerPadding,
        )
    }
}

