package com.jetpack.customcalendar.calendar

import com.jetpack.customcalendar.calendar.model.DatesSelectedState
import com.jetpack.customcalendar.calendar.model.DaySelected
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatesRepository @Inject constructor(
    datesLocalDataSource: DatesLocalDataSource,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) {
    val calendarYear = datesLocalDataSource.year2021
    val datesSelected = DatesSelectedState(datesLocalDataSource.year2021)

    suspend fun onDaySelected(daySelected: DaySelected) = withContext(defaultDispatcher) {
        datesSelected.daySelected(daySelected)
    }
}