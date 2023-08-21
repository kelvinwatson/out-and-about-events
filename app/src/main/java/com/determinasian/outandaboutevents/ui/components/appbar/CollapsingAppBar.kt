package com.determinasian.outandaboutevents.ui.components.appbar

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.determinasian.outandaboutevents.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingAppBar(topBarScrollBehavior: TopAppBarScrollBehavior) {

    LargeTopAppBar(
        navigationIcon = { AppBarDrawerIcon() } ,
        title = {
            Image(
                painterResource(id = R.drawable.ic_logo_with_text),
                contentDescription = stringResource(
                    id = R.string.logo_content_desc
                )
            )
        },
        scrollBehavior = topBarScrollBehavior
    )
}