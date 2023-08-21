package com.determinasian.outandaboutevents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.testTag
import com.determinasian.outandaboutevents.navigation.NavHost
import com.determinasian.outandaboutevents.ui.components.appbar.CollapsingAppBar
import com.determinasian.outandaboutevents.ui.components.navigation.BottomNav
import com.determinasian.outandaboutevents.ui.components.navigation.OabeBottomBarConstants

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun App(
    windowSizeClass: WindowSizeClass,
    appState: AppState = rememberAppState(windowSizeClass = windowSizeClass)
) {

    val topBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            // conditional rendering
            if (appState.isCurrentDestinationList) {
                CollapsingAppBar(topBarScrollBehavior = topBarScrollBehavior)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(topBarScrollBehavior.nestedScrollConnection),
        bottomBar = {
            if (appState.showBottomBar) {
                BottomNav(
                    currentDestination = appState.currentDestination,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    topLevelDestinations = appState.topLevelDestinations,
                    modifier = Modifier.testTag(OabeBottomBarConstants.TEST_TAG)
                )
            }
        }
    ) { innerPadding ->

        NavHost(appState = appState, modifier = Modifier.padding(innerPadding))
    }
}