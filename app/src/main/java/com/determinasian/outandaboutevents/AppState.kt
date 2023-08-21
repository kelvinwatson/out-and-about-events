package com.determinasian.outandaboutevents

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.determinasian.outandaboutevents.navigation.TopLevelDestination

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    windowSizeClass: WindowSizeClass,
): AppState = remember(
    navController,
    windowSizeClass
) { AppState(navController, windowSizeClass) }


@Stable
class AppState(
    val navController: NavHostController,
    private val windowSizeClass: WindowSizeClass
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val isCurrentDestinationList: Boolean
        @Composable get() = TopLevelDestination.List.route == currentDestination?.route

    val showBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact ||
                windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact

    val showNavRail: Boolean
        get() = !showBottomBar

    val topLevelDestinations = listOf(
        TopLevelDestination.List,
        TopLevelDestination.Faves,
        TopLevelDestination.Explore,
        TopLevelDestination.Account
    )

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        navController.navigate(topLevelDestination.route, navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when re-selecting a previously selected item
            restoreState = true
        })
    }
}