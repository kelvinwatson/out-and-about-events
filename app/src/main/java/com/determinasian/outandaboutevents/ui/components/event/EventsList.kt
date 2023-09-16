package com.determinasian.outandaboutevents.ui.components.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.determinasian.outandaboutevents.ui.theme.Dimens

val fakeEventIds = MutableList(100) { it }

@Composable
fun EventsList(onNavigateToDetails: (eventId: Long) -> Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(Dimens.PaddingStandard)) {
        fakeEventIds.forEach { eventId ->
            item(eventId) {
                val eventIdAsLong = eventId.toLong()
                EventCard(
                    eventId = eventIdAsLong,
                    thumbnailUrl = url,
                    host = if (eventId % 4 == 0) null else "Hosted by Gay Events".uppercase(),
                    sponsor = if (eventId % 2 == 0) null else "EventBrite".uppercase(),
                    title = "Some event title",
                    dateAndTimeRange = "Some date range",
                    location = "Some location",
                    isGrid = false,
                    suggestions = listOf("Dance party", "Men only"),
                    onEventCardClick = {

                        onNavigateToDetails(eventIdAsLong)
                    }
                )
            }
        }
    }
}

const val url = "https://images.pexels.com/photos/426976/pexels-photo-426976.jpeg"
