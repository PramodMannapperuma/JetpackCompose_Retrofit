package com.example.newsapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage

@Composable
fun CustomImg(
    modifier: Modifier = Modifier, imgUrl: String, height: Dp
) {
    AsyncImage(
        model = imgUrl,
        contentDescription = "Random Img",
        modifier = modifier
            .height(height)
            .fillMaxWidth()
    )
}