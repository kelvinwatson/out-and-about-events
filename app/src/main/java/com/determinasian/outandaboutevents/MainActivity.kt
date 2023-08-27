package com.determinasian.outandaboutevents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.determinasian.outandaboutevents.model.DarkThemeConfig
import com.determinasian.outandaboutevents.model.ThemeType
import com.determinasian.outandaboutevents.ui.theme.OutAndAboutEventsTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: UserSettingsViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var uiState: UserSettingsUiState by mutableStateOf(UserSettingsUiState.Loading)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.onEach {
                    Log.d(TAG, "UserSettingsUiState: $it")
                    uiState = it
                }.collect()
            }
        }

        setContent {
            val darkTheme = shouldUseDarkTheme(uiState)
            val themeType = getThemeType(uiState)

            OutAndAboutEventsTheme(
                darkTheme = darkTheme,
                themeType = themeType,
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    App(
                        windowSizeClass = calculateWindowSizeClass(activity = this)
                    )
                }
            }
        }
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
    }
}

@Composable
private fun shouldUseDarkTheme(
    uiState: UserSettingsUiState,
): Boolean = when (uiState) {
    UserSettingsUiState.Loading -> isSystemInDarkTheme()
    is UserSettingsUiState.Success -> when (uiState.userSettings.darkThemeConfig) {
        DarkThemeConfig.FOLLOW_SYSTEM -> isSystemInDarkTheme()
        DarkThemeConfig.LIGHT -> false
        DarkThemeConfig.DARK -> true
    }
}

@Composable
private fun getThemeType(uiState: UserSettingsUiState): ThemeType = when (uiState) {
    UserSettingsUiState.Loading -> ThemeType.APP_CUSTOM
    is UserSettingsUiState.Success -> uiState.userSettings.themeType
}