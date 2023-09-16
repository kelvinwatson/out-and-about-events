package com.determinasian.outandaboutevents.ui.components.appbar

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OabeTopBar(
    @StringRes currentToolbarTitle: Int,
    eventsListCollapsingToolbarScrollBehavior: TopAppBarScrollBehavior,
    isCurrentDestinationList: Boolean,
    isDarkMode: Boolean,
    pinnedToolbarScrollBehavior: TopAppBarScrollBehavior,
    onStandardAppBarBackPressed: () -> Unit,
) {
    if (isCurrentDestinationList) {
        CollapsingAppBar(
            isDarkMode = isDarkMode,
            toolbarScrollBehavior = eventsListCollapsingToolbarScrollBehavior,
        )
    } else {
        StandardAppBar(
            titleRes = currentToolbarTitle,
            topBarScrollBehavior = pinnedToolbarScrollBehavior,
            onBackPressed = onStandardAppBarBackPressed
        )
    }
}