package com.determinasian.outandaboutevents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.determinasian.outandaboutevents.dependencyinjection.FakeEventsListRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class EventsListViewModel: ViewModel() {
    val uiState: StateFlow<EventsListUiState> = FakeEventsListRepository.getEventsListData().map {
        EventsListUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = EventsListUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )
}

sealed interface EventsListUiState {
    data object Loading : EventsListUiState
    data class Success(val eventsData: EventsData) : EventsListUiState
}

data class EventsData(val mock:String="abc")