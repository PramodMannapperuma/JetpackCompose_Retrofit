package com.example.newsapplication.ui.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsapplication.ui.components.AppBar
import com.example.newsapplication.ui.components.CustomImg
import com.example.newsapplication.ui.components.PostCard
import com.example.newsapplication.viewModel.ProductViewModel

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductViewModel = viewModel(),
    paddingValues: PaddingValues
) {

    val productResponse by viewModel.products
    Scaffold(
        topBar = {
            AppBar(
                "Pky",
                navController = navController,
                showBackButton = false,
                showCartButton = true
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            if (productResponse.products.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    item {
                        CustomImg(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp),
                            imgUrl = "https://picsum.photos/400/200",
                            height = 200.dp
                        )
                    }
                    items(productResponse.products) {
                        PostCard(it, navController)
                    }
                }
            }
        }
    }
}
