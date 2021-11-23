package com.jetpack.customcalendar.calendar

import com.jetpack.customcalendar.calendar.model.CalendarMonth
import com.jetpack.customcalendar.calendar.model.DayOfWeek
import javax.inject.Inject
import javax.inject.Singleton

typealias CalendarYear = List<CalendarMonth>

@Singleton
class DatesLocalDataSource @Inject constructor() {
    private val january2021 = CalendarMonth(
        name = "January",
        year = "2021",
        numDays = 31,
        monthNumber = 1,
        startDayOfWeek = DayOfWeek.Friday
    )
    private val february2021 = CalendarMonth(
        name = "February",
        year = "2021",
        numDays = 28,
        monthNumber = 2,
        startDayOfWeek = DayOfWeek.Monday
    )
    private val march2021 = CalendarMonth(
        name = "March",
        year = "2021",
        numDays = 31,
        monthNumber = 3,
        startDayOfWeek = DayOfWeek.Monday
    )
    private val april2021 = CalendarMonth(
        name = "April",
        year = "2021",
        numDays = 30,
        monthNumber = 4,
        startDayOfWeek = DayOfWeek.Thursday
    )
    private val may2021 = CalendarMonth(
        name = "May",
        year = "2021",
        numDays = 31,
        monthNumber = 5,
        startDayOfWeek = DayOfWeek.Tuesday
    )
    private val june2021 = CalendarMonth(
        name = "June",
        year = "2021",
        numDays = 30,
        monthNumber = 6,
        startDayOfWeek = DayOfWeek.Tuesday
    )
    private val july2021 = CalendarMonth(
        name = "July",
        year = "2021",
        numDays = 31,
        monthNumber = 7,
        startDayOfWeek = DayOfWeek.Thursday
    )
    private val august2021 = CalendarMonth(
        name = "August",
        year = "2021",
        numDays = 31,
        monthNumber = 8,
        startDayOfWeek = DayOfWeek.Sunday
    )
    private val september2021 = CalendarMonth(
        name = "September",
        year = "2021",
        numDays = 30,
        monthNumber = 9,
        startDayOfWeek = DayOfWeek.Wednesday
    )
    private val october2021 = CalendarMonth(
        name = "October",
        year = "2021",
        numDays = 31,
        monthNumber = 10,
        startDayOfWeek = DayOfWeek.Friday
    )
    private val november2021 = CalendarMonth(
        name = "November",
        year = "2021",
        numDays = 30,
        monthNumber = 11,
        startDayOfWeek = DayOfWeek.Monday
    )
    private val december2021 = CalendarMonth(
        name = "December",
        year = "2021",
        numDays = 31,
        monthNumber = 12,
        startDayOfWeek = DayOfWeek.Wednesday
    )
    val year2021: CalendarYear = listOf(
        january2021,
        february2021,
        march2021,
        april2021,
        may2021,
        june2021,
        july2021,
        august2021,
        september2021,
        october2021,
        november2021,
        december2021
    )
}













