package com.example.newsapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.newsapplication.Routes
import com.example.newsapplication.data.models.Product


@Composable
fun PostCard(productResponse: Product, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                println("clicked id: ${productResponse.id}")
                navController.navigate("${Routes.ProductDetailScreen}/${productResponse.id}")
            }, colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .heightIn(min = 120.dp),
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(100.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f), // square box
                    contentAlignment = Alignment.Center
                ) {
//                    AsyncImage(
//                        model = productResponse.thumbnail,
//                        contentDescription = "Product Img",
//                    )
                    CustomImg(
                        imgUrl = productResponse.thumbnail,
                        height = 150.dp
                    )
                }
                Text(
                    text = "$ ${productResponse.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    productResponse.title ?: "Some Title",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
//                    textAlign = TextAlign.Center
                )
                Text(
                    productResponse.brand ?: "Some Brand",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
        }
    }
}