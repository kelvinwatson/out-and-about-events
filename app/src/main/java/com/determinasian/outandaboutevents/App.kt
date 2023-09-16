package com.determinasian.outandaboutevents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.testTag
import com.determinasian.outandaboutevents.navigation.AppGraph
import com.determinasian.outandaboutevents.ui.components.appbar.OabeTopBar
import com.determinasian.outandaboutevents.ui.components.navigation.BottomNav
import com.determinasian.outandaboutevents.ui.components.navigation.OabeBottomBarConstants
import com.determinasian.outandaboutevents.ui.modifier.conditional

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun App(
    windowSizeClass: WindowSizeClass,
    appState: AppState = rememberAppState(windowSizeClass = windowSizeClass)
) {

    // Must be hoisted to this level for nestedScroll modifier
    val eventListToolbarScrollBehavior = appState.collapsingToolbarScrollBehavior

    Scaffold(
        topBar = {
            OabeTopBar(appState, eventListToolbarScrollBehavior)
        },
        modifier = Modifier
            .fillMaxSize()
            .conditional(condition = appState.isCurrentDestinationList, ifTrue = {
                nestedScroll(eventListToolbarScrollBehavior.nestedScrollConnection)
            }),
        bottomBar = {
            if (appState.showBottomBar) {
                BottomNav(
                    navController = appState.navController,
                    modifier = Modifier.testTag(OabeBottomBarConstants.TEST_TAG)
                )
            }
        }
    ) { innerPadding ->

        AppGraph(
            navController = appState.navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}