package com.example.newsapplication.ui.view.productView

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.newsapplication.ui.components.AppBar


@Composable
fun ItemDetailsScreen(productId: Int?, navController: NavHostController) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Details",
                navController = navController,
                showBackButton = true,
                showCartButton = true
            )
        }) { innerPadding ->
        ProductDetailScreen(productId, innerPadding)
        println("product Id in productdetails : $productId")
    }
}