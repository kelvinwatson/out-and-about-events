package com.determinasian.outandaboutevents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.determinasian.outandaboutevents.dependencyinjection.Singletons.fakeUserSettingsUseCase
import com.determinasian.outandaboutevents.model.UserSettings
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class UserSettingsViewModel : ViewModel() {

    val uiState: StateFlow<UserSettingsUiState> = fakeUserSettingsUseCase.getUserSettings().map {
        UserSettingsUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = UserSettingsUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )
}

sealed interface UserSettingsUiState {
    data object Loading : UserSettingsUiState
    data class Success(val userSettings: UserSettings) : UserSettingsUiState
}
