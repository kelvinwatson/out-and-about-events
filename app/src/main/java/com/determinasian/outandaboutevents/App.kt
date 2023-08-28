package com.determinasian.outandaboutevents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.determinasian.outandaboutevents.navigation.AppGraph
import com.determinasian.outandaboutevents.ui.components.navigation.BottomNav
import com.determinasian.outandaboutevents.ui.components.navigation.OabeBottomBarConstants

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun App(navController: NavHostController = rememberNavController()) {

//    val toolbarScrollBehavior = rootState.collapsingToolbarScrollBehavior
    Scaffold(
//        topBar = {
//            // conditional rendering
//            if (rootState.isCurrentDestinationList) {
//                CollapsingAppBar(toolbarScrollBehavior, rootState.isDarkMode)
//            }
//        },
//        modifier = Modifier
//            .fillMaxSize()
//            .nestedScroll(toolbarScrollBehavior.nestedScrollConnection),
        bottomBar = {
//            if (rootState.showBottomBar) {
            BottomNav(
                navController = navController,
                modifier = Modifier.testTag(OabeBottomBarConstants.TEST_TAG)
            )
//            }
        }
    ) { innerPadding ->

        AppGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}