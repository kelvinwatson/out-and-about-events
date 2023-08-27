package com.determinasian.outandaboutevents.ui.components.event

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import com.determinasian.outandaboutevents.R
import com.determinasian.outandaboutevents.ui.theme.Dimens.CardContentPadding
import com.determinasian.outandaboutevents.ui.theme.Dimens.CardPadding
import com.determinasian.outandaboutevents.ui.theme.Dimens.ImageRoundedCorner
import com.determinasian.outandaboutevents.ui.theme.Dimens.ImageThumbnailSize
import com.determinasian.outandaboutevents.ui.theme.Dimens.SuggestionChipSpacing
import com.determinasian.outandaboutevents.ui.theme.toPx

/**
 * Any parameters should be provided in displayble format.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCard(
    eventId: Long,
    thumbnailUrl: String,
    sponsor: String? = null,
    title: String,
    dateAndTimeRange: String,
    location: String,
    isGrid: Boolean = false, // TODO support a grid view
    suggestions: List<String>? = null,
    onEventCardClick: (Long) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(CardPadding)
            .semantics(mergeDescendants = true) {},
        onClick = { onEventCardClick(eventId) }) {

        Row(
            modifier = Modifier
                .padding(CardContentPadding),
        ) {
            Column(
                modifier = Modifier
                    .weight(1.0f)
                    .align(CenterVertically)
                    .padding(horizontal = CardContentPadding)
            ) {

                sponsor.takeIf { !it.isNullOrBlank() }?.let {
                    Text(
                        text = it,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dateAndTimeRange,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = location,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                )
                if (!suggestions.isNullOrEmpty()) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(SuggestionChipSpacing)
                    ) {
                        suggestions.forEach {
                            SuggestionChip(
                                label = {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                },
                                colors = SuggestionChipDefaults.suggestionChipColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                                onClick = { /*TODO*/ })
                        }
                    }
                }
            }

            AsyncImage(
                modifier = Modifier
                    .size(ImageThumbnailSize)
                    .clip(
                        RoundedCornerShape(ImageRoundedCorner)
                    )
                    .align(CenterVertically),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(thumbnailUrl)
                    .size(Size(ImageThumbnailSize.toPx(), ImageThumbnailSize.toPx()))
                    .scale(Scale.FIT)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Fit,
                placeholder = debugPlaceholder(R.drawable.ic_logo_with_text),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) = if (LocalInspectionMode.current) {
    painterResource(id = debugPreview)
} else {
    null
}

@[Composable Preview]
fun EventCardPreview() {
    EventCard(
        eventId = 0L,
        thumbnailUrl = "",
        sponsor = "EventBrite",
        title = "Some event title",
        dateAndTimeRange = "Some date range",
        location = "Some location",
        isGrid = false,
        suggestions = listOf("dance party", "exciting"),
        onEventCardClick = {}
    )
}