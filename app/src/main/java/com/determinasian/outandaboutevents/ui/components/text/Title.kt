package com.determinasian.outandaboutevents.ui.components.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier
            .then(modifier)
            .padding(vertical = 16.dp),
        text = text,
        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium)
    )
}