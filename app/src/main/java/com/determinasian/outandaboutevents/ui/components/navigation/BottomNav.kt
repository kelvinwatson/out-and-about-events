package com.determinasian.outandaboutevents.ui.components.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.determinasian.outandaboutevents.navigation.TopLevelDestination

val topLevelDestinations = listOf(
    TopLevelDestination.List,
    TopLevelDestination.Faves,
    TopLevelDestination.Explore,
    TopLevelDestination.Account
)

@Composable
fun BottomNav(
    navController: NavHostController,

//    currentDestination: NavDestination?,
//    onNavigateToDestination: (TopLevelDestination) -> Unit,
//    topLevelDestinations: List<TopLevelDestination>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        topLevelDestinations.forEach { topLevelDestination ->
//            val isCurrentTopLevelDestination = currentDestination?.route == topLevelDestination.route
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = topLevelDestination.icon,
                        contentDescription = stringResource(topLevelDestination.iconContentDescription)
                    )
                },
                label = { Text(stringResource(topLevelDestination.name)) },
                onClick = {
                    navController.navigate(topLevelDestination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentRoute == topLevelDestination.route,
                alwaysShowLabel = false
            )
        }
    }
}

object OabeBottomBarConstants {
    const val TEST_TAG = "OabeBottomBar"
}