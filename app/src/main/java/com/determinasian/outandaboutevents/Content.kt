package com.determinasian.outandaboutevents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.determinasian.outandaboutevents.navigation.TopLevelDestination
import com.determinasian.outandaboutevents.navigation.topLevelDestinations

@Composable
fun Content(navController: NavHostController = rememberNavController()) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {

                topLevelDestinations.forEach { topLevelDestination ->
                    val isCurrentTopLevelDestination =
                        topLevelDestination.route == backStackEntry.value?.destination?.route
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = topLevelDestination.icon,
                                contentDescription = stringResource(topLevelDestination.iconContentDescription)
                            )
                        },
                        label = { Text(stringResource(topLevelDestination.name)) },
                        onClick = { navController.navigate(topLevelDestination.route) },
                        selected = isCurrentTopLevelDestination
                    )
                }
            }

        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = TopLevelDestination.List.route,
            Modifier.padding(innerPadding)
        ) {
            composable(TopLevelDestination.List.route) {
                Text("hello list")
            }
            composable(TopLevelDestination.Faves.route) {
                Text("hello faves")
            }
            composable(TopLevelDestination.Account.route) {
                Text("hello account")
            }
        }
    }
}