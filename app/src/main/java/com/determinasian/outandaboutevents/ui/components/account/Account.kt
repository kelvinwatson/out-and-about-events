package com.determinasian.outandaboutevents.ui.components.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.determinasian.outandaboutevents.R
import com.determinasian.outandaboutevents.ui.components.text.SubTitle
import com.determinasian.outandaboutevents.ui.components.text.Title

@Composable
fun Account(
    onNavigateToUserSettings: () -> Unit,
    onNavigateToDeveloperSettings: () -> Unit,
) {

    LazyColumn {
        item {
            Title(text = "Profile")
        }
        item {
            Row {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.sample_avatar)
                        .crossfade(true)
                        .build(),
//                    placeholder = painterResource(R.drawable.placeholder),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .weight(1f)
                )

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = "Christian Morris", style = MaterialTheme.typography.titleMedium)
                    Text("Tier 3 subscribed")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Text("Upgrade subscription")
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Title(text = "Settings")
        }
        item {
            Column(modifier = Modifier
                .heightIn(min = 48.dp)
                .fillMaxWidth()
                .clickable {
                    onNavigateToUserSettings()
                }
                .padding(vertical = 16.dp)
            ) {
                SubTitle(text = "User settings")
                Text("User settings and preferences")
            }
            Divider()
        }
        item {
            Column(modifier = Modifier
                .heightIn(min = 48.dp)
                .fillMaxWidth()
                .clickable {
                    onNavigateToDeveloperSettings()
                }
                .padding(vertical = 16.dp)
            ) {
                SubTitle(text = "Developer settings")
                Text("Advanced adjustments, toggle new and experimental features, etc.")
            }
            Divider()
        }
    }
}

@Preview
@Composable
fun PreviewAccount() {
    Account({}, {})
}