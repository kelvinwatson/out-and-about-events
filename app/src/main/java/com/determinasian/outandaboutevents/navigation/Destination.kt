package com.determinasian.outandaboutevents.navigation

import androidx.annotation.StringRes
import com.determinasian.outandaboutevents.R

sealed class Destination(
    @StringRes val name: Int,
    val route: String,
) {
    data object Detail : Destination(
        R.string.detail,
        "Detail"
    )

    data object UserSettings : Destination(
        R.string.user_settings,
        "UserSettings"
    )

    data object DeveloperSettings : Destination(
        R.string.developer_settings,
        "DeveloperSettings"
    )
}