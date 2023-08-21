package com.determinasian.outandaboutevents.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.mutableStateOf

/**
 * Allows stubbing for tests.
 */
object ThemeHelper {


    // non dynamic-color theme
    var useStandardTheme: MutableState<Boolean> = mutableStateOf(true)

    @Composable
    @ReadOnlyComposable
    fun isDarkMode(): Boolean = isSystemInDarkTheme()
}