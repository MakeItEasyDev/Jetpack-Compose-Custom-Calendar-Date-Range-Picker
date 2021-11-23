package com.jetpack.customcalendar.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.customcalendar.calendar.model.DaySelected
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val datesRepository: DatesRepository
): ViewModel() {
    val datesSelected = datesRepository.datesSelected
    val calendarYear = datesRepository.calendarYear

    fun onDaySelected(daySelected: DaySelected) {
        viewModelScope.launch {
            datesRepository.onDaySelected(daySelected)
        }
    }
}