package com.determinasian.outandaboutevents.ui.components.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Explore(onNavigateToEventDetail: () -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        // Banner carousel
        nearYouCarousel()

        // Event carousel
        postersHorizontalList()
    }
}