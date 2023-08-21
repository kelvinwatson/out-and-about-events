package com.determinasian.outandaboutevents.ui.components.appbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.determinasian.outandaboutevents.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardAppBar(topBarScrollBehavior: TopAppBarScrollBehavior) {

    TopAppBar(
        navigationIcon = {
            AppBarDrawerIcon()
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(stringResource(id = R.string.app_name))
            }
        },
        scrollBehavior = topBarScrollBehavior
    )
}