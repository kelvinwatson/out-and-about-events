package com.determinasian.outandaboutevents.dependencyinjection

import com.determinasian.outandaboutevents.EventsData
import com.determinasian.outandaboutevents.ui.theme.ThemeHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * todo use dagger, hilt or koin
 */
object Singletons {

    val themeHelper: ThemeHelper = ThemeHelper

    val fakeRepository: FakeEventsListRepository = FakeEventsListRepository

}

object FakeEventsListRepository {
    fun getEventsListData(): Flow<EventsData> = flow {
        emit(EventsData("abcdefg"))
    }
}