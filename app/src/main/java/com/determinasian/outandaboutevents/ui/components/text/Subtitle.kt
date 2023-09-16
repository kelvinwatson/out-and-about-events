package com.determinasian.outandaboutevents.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SubTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = MaterialTheme.typography.titleMedium
    )
}