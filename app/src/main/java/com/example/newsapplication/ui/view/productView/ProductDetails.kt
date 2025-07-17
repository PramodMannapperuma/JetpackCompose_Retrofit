package com.example.newsapplication.ui.view.productView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapplication.ui.components.CustomImg
import com.example.newsapplication.viewModel.ProductViewModel

@Composable
fun ProductDetailScreen(
    productId: Int?, innerPadding: PaddingValues, viewModel: ProductViewModel = viewModel()
) {

    val productList = viewModel.products.value.products
    val product = productList.find { it.id == productId }

    if (product == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Product not found", style = MaterialTheme.typography.bodyLarge)
        }
        return
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(16.dp)
    ) {
        CustomImg(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            imgUrl = product.thumbnail,
            height = 240.dp
        )

        Text(
            product.title ?: "No Title", style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text("Product title is : ${product.title}")
        // Brand
        Text(
            text = "Brand: ${product.brand ?: "Unknown"}",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Price
        Text(
            text = "Price: $${product.price ?: 0}",
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = product.description ?: "No description available.",
            style = MaterialTheme.typography.bodyLarge,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Action Button
        Button(
            onClick = { /* TODO: Add to cart or navigate */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Buy Now")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "More in '${product.category}'",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            val similarProducts = productList.filter {
                it.id != product.id && it.category == product.category
            }

            items(similarProducts.take(10)) { similarProduct ->
                Column(
                    modifier = Modifier
                        .width(140.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(8.dp)
                ) {
                    CustomImg(
                        imgUrl = similarProduct.thumbnail ?: "",
                        height = 100.dp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = similarProduct.title ?: "No Title",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "$${similarProduct.price}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
        }
    }
}