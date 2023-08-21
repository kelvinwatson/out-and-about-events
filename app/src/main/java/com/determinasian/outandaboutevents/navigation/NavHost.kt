package com.determinasian.outandaboutevents.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.determinasian.outandaboutevents.AppState
import com.determinasian.outandaboutevents.ui.components.eventslist.EventsList

@Composable
fun NavHost(appState: AppState, modifier: Modifier = Modifier) {
    NavHost(
        navController = appState.navController,
        startDestination = TopLevelDestination.List.route,
        modifier = Modifier.then(modifier)
    ) {
        composable(TopLevelDestination.List.route) {
            EventsList()
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