package com.determinasian.outandaboutevents.ui.components.appbar

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import com.determinasian.outandaboutevents.R


@Composable
fun AppBarBackArrowIcon(onBackPressed: () -> Unit) {
    IconButton(onClick = {
        onBackPressed()
    }) {

        Image(
            imageVector = Icons.Sharp.ArrowBack,
            contentDescription = stringResource(R.string.menu_icon_content_desc),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
    }
}