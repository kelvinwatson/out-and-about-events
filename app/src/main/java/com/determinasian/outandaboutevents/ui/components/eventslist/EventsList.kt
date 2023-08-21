package com.determinasian.outandaboutevents.ui.components.eventslist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EventsList() {
    LazyColumn {
        items(100) {
            Text("hello list")
        }
    }
}