package com.example.newsapplication.ui.view.productView

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.newsapplication.ui.components.AppBar


@Composable
fun ItemDetailsScreen(productId: Int?, navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Details",
                navController = navController,
                showBackButton = true,
                showCartButton = true
            )
        }) { innerPadding ->
        ProductDetailScreen(navController,productId, innerPadding)
        println("product Id in productdetails : $productId")
    }
}