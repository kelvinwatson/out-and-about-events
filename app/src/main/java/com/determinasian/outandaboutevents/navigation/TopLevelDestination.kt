package com.determinasian.outandaboutevents.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.determinasian.outandaboutevents.R

sealed class TopLevelDestination(
    @StringRes val name: Int,
    val route: String,
    val icon: ImageVector,
    @StringRes val iconContentDescription: Int
) {
    data object List : TopLevelDestination(
        R.string.list,
        "List",
        Icons.Sharp.List,
        R.string.list_icon_content_desc
    )

    data object Faves : TopLevelDestination(
        R.string.faves,
        "Faves",
        Icons.Sharp.Favorite,
        R.string.faves_icon_content_desc
    )

    data object Account : TopLevelDestination(
        R.string.account,
        "Account",
        Icons.Sharp.AccountBox,
        R.string.account_icon_content_desc
    )
}

val topLevelDestinations = listOf(
    TopLevelDestination.List,
    TopLevelDestination.Faves,
    TopLevelDestination.Account
)
