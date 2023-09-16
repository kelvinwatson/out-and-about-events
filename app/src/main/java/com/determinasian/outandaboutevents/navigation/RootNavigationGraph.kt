package com.determinasian.outandaboutevents.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.determinasian.outandaboutevents.App

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootNavigationGraph(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController,
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        route = Graph.Routes.ROOT,
        startDestination = Graph.Routes.APP
    ) {

        composable(route = Graph.Routes.APP) {
            App(windowSizeClass = windowSizeClass)
        }
    }
}