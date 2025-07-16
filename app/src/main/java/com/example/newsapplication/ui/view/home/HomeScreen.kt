package com.example.newsapplication.ui.view.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.newsapplication.ui.components.AppBar

@Composable
fun HomePage(navController: NavHostController) {
    Scaffold(
        topBar = {
            AppBar("Products")
        }
    ) { innerPadding ->
        ProductListScreen(
            navController,
            paddingValues = innerPadding,
        )
    }
}

