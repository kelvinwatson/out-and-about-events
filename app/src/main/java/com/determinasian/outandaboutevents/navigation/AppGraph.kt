package com.determinasian.outandaboutevents.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.determinasian.outandaboutevents.ui.components.event.EventsList
import com.determinasian.outandaboutevents.ui.theme.Dimens

@Composable
fun AppGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        route = Graph.Routes.APP,
        startDestination = TopLevelDestination.List.route,
        modifier = Modifier
            .then(modifier)
            .padding(horizontal = Dimens.PaddingStandard)
    ) {

        composable(TopLevelDestination.List.route) {
            EventsList(onNavigateToDetails = {
                navController.navigate(route = Destination.Detail.route)
            })
        }
        composable(TopLevelDestination.Faves.route) {
            Text("hello faves")
        }
        composable(TopLevelDestination.Explore.route) {
            Text("hello explore other cities, coming soon!")
        }
        composable(TopLevelDestination.Account.route) {
            LazyColumn {
                item {
                    Button(onClick = {
                        navController.navigate(route = Destination.Settings.route)
                    }) {
                        Text("Settings")
                    }
                }
                item {
                    Button(onClick = {
                        navController.navigate(route = Destination.DeveloperSettings.route)
                    }) {
                        Text("Developer Settings")
                    }
                }
            }
        }

        // we'd only ever need to view one detail at a time, so we add it to the top level nav graph
        composable(Destination.Detail.route) {
            Text("Hello event detail")
        }

        composable(Destination.Settings.route) {
            Text("Hello settings")
        }

        composable(Destination.DeveloperSettings.route) {
            Text("Hello developer settings")
        }
    }
}