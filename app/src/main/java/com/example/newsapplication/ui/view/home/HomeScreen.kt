package com.example.newsapplication.ui.view.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.newsapplication.ui.components.AppBar

@Composable
fun HomePage() {
    Scaffold(
        topBar = {
            AppBar("Products")
        }
    ) { innerPadding ->
        ProductListScreen(
            paddingValues = innerPadding
        )
    }
}

