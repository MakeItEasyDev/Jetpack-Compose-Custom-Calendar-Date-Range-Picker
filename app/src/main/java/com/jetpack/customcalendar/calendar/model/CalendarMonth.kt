package com.jetpack.customcalendar.calendar.model

data class CalendarMonth(
    val name: String,
    val year: String,
    val numDays: Int,
    val monthNumber: Int,
    val startDayOfWeek: DayOfWeek
) {
    private val days = mutableListOf<CalendarDay>().apply {
        for (i in 1..startDayOfWeek.ordinal) {
            add(
                CalendarDay(
                    "",
                    DaySelectedStatus.NonClickable
                )
            )
        }
        for (i in 1..numDays) {
            add(
                CalendarDay(
                    i.toString(),
                    DaySelectedStatus.NoSelected
                )
            )
        }
    }.toList()

    fun getDay(day: Int): CalendarDay {
        return days[day + startDayOfWeek.ordinal - 1]
    }

    fun getPreviousDay(day: Int): CalendarDay? {
        if (day <= 1) return null
        return getDay(day - 1)
    }

    fun getNextDay(day: Int): CalendarDay? {
        if (day >= numDays) return null
        return getDay(day + 1)
    }

    val weeks = lazy { days.chunked(7).map { completeWeek(it) } }

    private fun completeWeek(list: List<CalendarDay>): List<CalendarDay> {
        var gapsToFill = 7 - list.size

        return if (gapsToFill != 0) {
            val mutableList = list.toMutableList()
            while (gapsToFill > 0) {
                mutableList.add(
                    CalendarDay(
                        "",
                        DaySelectedStatus.NonClickable
                    )
                )
                gapsToFill--
            }
            mutableList
        } else {
            list
        }
    }
}

























