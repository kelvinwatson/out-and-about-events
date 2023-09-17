package com.determinasian.outandaboutevents.ui.components.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.determinasian.outandaboutevents.R
import com.determinasian.outandaboutevents.ui.components.text.Title

fun LazyListScope.postersHorizontalList() {
    item {
        Column {
            Title(text = "Around the world")
            Text(text = "Going traveling? Let's have some fun")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    item {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(posterDrawables) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                )
            }
        }
    }
}

val posterDrawables = listOf(
    R.drawable.sample_poster_1,
    R.drawable.sample_poster_2,
    R.drawable.sample_poster_3,
    R.drawable.sample_poster_4,
    R.drawable.sample_poster_5
)