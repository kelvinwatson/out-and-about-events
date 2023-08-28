package com.determinasian.outandaboutevents.ui.components.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.determinasian.outandaboutevents.ui.theme.Dimens

val fakeEventIds = MutableList(100) { it }

@Composable
fun EventsList(navController: NavController) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(Dimens.SpacerHeightStandard)) {
        fakeEventIds.forEach { eventId ->
            item(eventId) {
                EventCard(
                    eventId = eventId.toLong(),
                    thumbnailUrl = problematicUrl,
                    source = if (eventId % 3 == 0) null else "Anonymous source".uppercase(),
                    sponsor = if (eventId % 2 == 0) null else "EventBrite".uppercase(),
                    title = "Some event title",
                    dateAndTimeRange = "Some date range",
                    location = "Some location",
                    isGrid = false,
                    suggestions = listOf("Dance party", "Men only"),
                    onEventCardClick = {}
                )
            }
        }
    }
}

const val problematicUrl = "https://images.pexels.com/photos/426976/pexels-photo-426976.jpeg"
const val url =
    "https://media.istockphoto.com/id/1372401945/photo/modern-black-picture-or-square-photo-frame-isolated.webp?b=1&s=170667a&w=0&k=20&c=bmXOZlLuoGDq9RtS64i1JWl8nz1lKg-2hVE1SRT8I8E="