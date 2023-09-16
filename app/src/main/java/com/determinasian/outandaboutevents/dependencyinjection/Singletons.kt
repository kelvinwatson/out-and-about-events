package com.determinasian.outandaboutevents.dependencyinjection

import com.determinasian.outandaboutevents.model.DarkThemeConfig
import com.determinasian.outandaboutevents.model.ThemeType
import com.determinasian.outandaboutevents.model.UserSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * todo use dagger, hilt or koin
 */
object Singletons {
    val fakeUserSettingsUseCase: FakeGetUserSettingsUseCase = FakeGetUserSettingsUseCase
}

object FakeGetUserSettingsUseCase {
    fun getUserSettings(): Flow<UserSettings> = FakeUserSettingsRepository.getUserSettings()
}

object FakeUserSettingsRepository {
    fun getUserSettings(): Flow<UserSettings> = flow {
        emit(
            UserSettings(
                darkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM,
                themeType = ThemeType.APP_CUSTOM,
                useDynamicColor = false
            )
        )
    }
}