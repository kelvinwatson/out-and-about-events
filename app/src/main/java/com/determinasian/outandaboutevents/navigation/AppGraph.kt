package com.determinasian.outandaboutevents.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.determinasian.outandaboutevents.ui.components.event.EventsList

@Composable
fun AppGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
//    appState: AppState = rememberAppState(windowSizeClass = rootState.windowSizeClass),
) {
    NavHost(
        navController = navController,
        route = Graph.Routes.APP,
        startDestination = TopLevelDestination.List.route,
        modifier = Modifier.then(modifier)
    ) {
        composable(TopLevelDestination.List.route) {
            EventsList(navController = navController)
        }
        composable(TopLevelDestination.Faves.route) {
            Text("hello faves")
        }
        composable(TopLevelDestination.Explore.route) {
            Text("hello explore other cities, coming soon!")
        }
        composable(TopLevelDestination.Account.route) {
            Text("hello account")
        }
    }
}