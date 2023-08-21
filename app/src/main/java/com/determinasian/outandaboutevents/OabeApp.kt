package com.determinasian.outandaboutevents

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.determinasian.outandaboutevents.navigation.OabeBottomBar
import com.determinasian.outandaboutevents.navigation.OabeNavHost

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OabeApp(
    windowSizeClass: WindowSizeClass,
    appState: OabeAppState = rememberAppState(windowSizeClass = windowSizeClass)
) {

    val topBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            // conditional rendering
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(topBarScrollBehavior.nestedScrollConnection),
        bottomBar = {
            OabeBottomBar(
                topLevelDestinations = appState.topLevelDestinations,
                onNavigateToDestination = appState::navigateToTopLevelDestination,
                currentDestination = appState.currentDestination
            )
        }
    ) { innerPadding ->

        OabeNavHost(appState = appState, modifier = Modifier.padding(innerPadding))
    }
}