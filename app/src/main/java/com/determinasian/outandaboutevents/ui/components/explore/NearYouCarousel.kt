package com.determinasian.outandaboutevents.ui.components.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.determinasian.outandaboutevents.R
import com.determinasian.outandaboutevents.ui.components.text.Title

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.nearYouCarousel() {
    item {
        Column {
            Title(text = "Parties near you")
            Text(text = "Events found by AI happening soon in your neighbourhood")
            Spacer(modifier = Modifier.height(16.dp))

            val bannerPagerState = rememberPagerState(pageCount = {
                4
            })
            HorizontalPager(
                state = bannerPagerState,
            ) { page ->
                // Card content
                val bannerDrawable = when (page) {
                    0 -> R.drawable.sample_banner_models
                    1 -> R.drawable.sample_banner_claw
                    2 -> R.drawable.sample_banner_leather
                    else -> R.drawable.sample_banner_bluf
                }

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(bannerDrawable)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(4) { iteration ->
                    val color =
                        if (bannerPagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(20.dp)

                    )
                }
            }
        }
    }
}