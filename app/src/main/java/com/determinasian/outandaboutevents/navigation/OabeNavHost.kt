package com.determinasian.outandaboutevents.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.determinasian.outandaboutevents.OabeAppState
import com.determinasian.outandaboutevents.eventslist.EventsList

@Composable
fun OabeNavHost(appState: OabeAppState, modifier: Modifier = Modifier) {
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