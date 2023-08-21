package com.determinasian.outandaboutevents.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination

@Composable
fun OabeBottomBar(
    topLevelDestinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar {
        topLevelDestinations.forEach { topLevelDestination ->
            val isCurrentTopLevelDestination = currentDestination?.route == topLevelDestination.route
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = topLevelDestination.icon,
                        contentDescription = stringResource(topLevelDestination.iconContentDescription)
                    )
                },
                label = { Text(stringResource(topLevelDestination.name)) },
                onClick = { onNavigateToDestination(topLevelDestination) },
                selected = isCurrentTopLevelDestination
            )
        }
    }
}