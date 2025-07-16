package com.example.newsapplication.ui.view.productView

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.newsapplication.ui.components.AppBar


@Composable
fun ItemDetailsScreen(productId: Int?) {
    Scaffold(
        topBar = {
            AppBar(title = "Details")
        }) { innerPadding ->
        ProductDetailScreen(productId, innerPadding)
        println("product Id in productdetails : $productId")
    }
}