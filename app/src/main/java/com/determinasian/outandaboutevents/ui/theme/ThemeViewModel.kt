package com.determinasian.outandaboutevents.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ThemeViewModel : ViewModel() {
    enum class ThemeType {
        // Dynamic color is available on Android 12+

        STANDARD, DYNAMIC_COLOR
    }
    /**
     * Use the non-dynamic-color theme
     */
    private var _themeType = MutableStateFlow(ThemeType.STANDARD)
    val themeType: StateFlow<ThemeType>
        get() = _themeType

    @Composable
    fun darkTheme():Boolean = isSystemInDarkTheme()
}