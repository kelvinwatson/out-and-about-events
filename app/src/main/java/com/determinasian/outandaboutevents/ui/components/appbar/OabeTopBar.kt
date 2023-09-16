package com.determinasian.outandaboutevents.ui.components.appbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import com.determinasian.outandaboutevents.AppState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OabeTopBar(
    appState: AppState,
    eventsListCollapsingToolbarScrollBehavior: TopAppBarScrollBehavior
) {
    if (appState.isCurrentDestinationList) {
        CollapsingAppBar(
            toolbarScrollBehavior = eventsListCollapsingToolbarScrollBehavior,
            isDarkMode = appState.isDarkMode
        )
    } else {
        StandardAppBar(
            titleRes = appState.currentToolbarTitle,
            topBarScrollBehavior = appState.pinnedToolbarScrollBehavior
        )
    }
}