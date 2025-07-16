package com.example.newsapplication.ui.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapplication.data.models.Product
import com.example.newsapplication.ui.components.HomeImage
import com.example.newsapplication.ui.theme.PurpleGrey40
import com.example.newsapplication.viewModel.PostViewModel

@Composable
fun ProductListScreen(viewModel: PostViewModel = viewModel(), paddingValues: PaddingValues) {

    val productResponse by viewModel.products

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        HomeImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding( top = 2.dp)
        )

        if (productResponse.products.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                contentAlignment = Alignment.Center

            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(productResponse.products) {
                    PostCard(it)
                }
            }
        }
    }

}


@Composable
fun PostCard(productResponse: Product) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(PurpleGrey40),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Product #${productResponse.id}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Text(
                productResponse.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                productResponse.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
    }
}