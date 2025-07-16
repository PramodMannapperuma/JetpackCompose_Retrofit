package com.example.newsapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay

@Composable
fun HomeImage(modifier: Modifier = Modifier){
    var refreshKey by remember { mutableStateOf(System.currentTimeMillis()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(30_000)
            refreshKey = System.currentTimeMillis()
        }
    }

    val imageUrl = "https://picsum.photos/400/200?t=$refreshKey"

    AsyncImage(
        model = imageUrl,
        contentDescription = "Random Img",
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
    )
}