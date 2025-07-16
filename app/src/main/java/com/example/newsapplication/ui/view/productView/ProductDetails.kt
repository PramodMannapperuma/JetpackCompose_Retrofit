package com.example.newsapplication.ui.view.productView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductDetailScreen(productId: Int?, innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(innerPadding)) {
        Text("Product details for ID: $productId")
    }
}