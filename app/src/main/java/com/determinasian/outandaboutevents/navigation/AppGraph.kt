package com.determinasian.outandaboutevents.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
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

        eventListGraph(navController = navController)

        favesGraph(navController = navController)

        detailGraph(navController = navController)

        accountGraph(navController = navController)

        settingsGraph(navController = navController)
        developerSettingsGraph(navController = navController)
    }
}

fun NavGraphBuilder.eventListGraph(navController: NavController) {
    composable(TopLevelDestination.List.route) {
        EventsList(onNavigateToDetails = {
            navController.navigate(route = Destination.Detail.route)
        })
    }
}

fun NavGraphBuilder.detailGraph(navController: NavController) {
    // we'd only ever need to view one detail at a time, so we add it to the top level nav graph
    composable(Destination.Detail.route) {
        Column {
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("fake back arrow")
            }
            Text("Hello event detail")
        }
    }
}

fun NavGraphBuilder.favesGraph(navController: NavController) {
    composable(TopLevelDestination.Faves.route) {
        Text("hello faves")
    }
}

fun NavGraphBuilder.settingsGraph(navController: NavController) {
    composable(Destination.DeveloperSettings.route) {
        Text("Hello settings")
    }
}

fun NavGraphBuilder.developerSettingsGraph(navController: NavController) {
    composable(Destination.DeveloperSettings.route) {
        Text("Hello developer settings")
    }
}

fun NavGraphBuilder.accountGraph(navController: NavController) {
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
}