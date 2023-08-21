package com.determinasian.outandaboutevents.ui.components.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.determinasian.outandaboutevents.navigation.TopLevelDestination

@Composable
fun BottomNav(
    currentDestination: NavDestination?,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    topLevelDestinations: List<TopLevelDestination>,
    modifier:Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
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

object OabeBottomBarConstants {
    const val TEST_TAG = "OabeBottomBar"
}