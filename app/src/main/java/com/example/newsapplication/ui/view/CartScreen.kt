package com.example.newsapplication.ui.view

// CartScreen.kt

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsapplication.ui.components.AppBar
import com.example.newsapplication.ui.components.CustomImg
import com.example.newsapplication.viewModel.ProductViewModel

@Composable
fun CartScreen(navController: NavController,viewModel: ProductViewModel = viewModel() ) {
    val cartItems = viewModel.cartItems
    Scaffold(topBar = {
        AppBar(
            title = "Cart",
            navController = navController,
            showBackButton = true,
            showCartButton = false
        )
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Your Cart",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (cartItems.isEmpty()) {
                Text("Your cart is empty.")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(cartItems) { product ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation()
                        ) {
                            Row(modifier = Modifier.padding(12.dp)) {
                                CustomImg(
                                    imgUrl = product.thumbnail ?: " ",
                                    height = 60.dp,
                                    modifier = Modifier.size(60.dp)
                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                Column {
                                    Text(product.title ?: "Unknown", style = MaterialTheme.typography.bodyLarge)
                                    Text("$${product.price}", color = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
