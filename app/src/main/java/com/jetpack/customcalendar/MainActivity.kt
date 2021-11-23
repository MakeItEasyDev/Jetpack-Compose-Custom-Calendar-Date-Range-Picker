package com.jetpack.customcalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.jetpack.customcalendar.calendar.Calendar
import com.jetpack.customcalendar.calendar.CalendarViewModel
import com.jetpack.customcalendar.calendar.CalendarYear
import com.jetpack.customcalendar.calendar.model.CalendarDay
import com.jetpack.customcalendar.calendar.model.CalendarMonth
import com.jetpack.customcalendar.calendar.model.DaySelected
import com.jetpack.customcalendar.ui.theme.CustomCalendarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProvideWindowInsets {
                CustomCalendarTheme {
                    CalendarScreen(onBackPressed = { finish() })
                }
            }
        }
    }
}

@Composable
fun CalendarScreen(
    onBackPressed: () -> Unit
) {
    val calendarViewModel: CalendarViewModel = viewModel()
    val calendarYear = calendarViewModel.calendarYear

    CalendarContent(
        selectedDates = calendarViewModel.datesSelected.toString(),
        calendarYear = calendarYear,
        onDayClicked = { calendarDay, calendarMonth ->
            calendarViewModel.onDaySelected(
                DaySelected(calendarDay.value.toInt(), calendarMonth, calendarYear)
            )
        },
        onBackPressed = onBackPressed
    )
}

@Composable
fun CalendarContent(
    selectedDates: String,
    calendarYear: CalendarYear,
    onDayClicked: (CalendarDay, CalendarMonth) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            CalendarTopAppBar(selectedDates, onBackPressed)
        }
    ) {
        Calendar(calendarYear, onDayClicked)
    }
}

@Composable
fun CalendarTopAppBar(selectedDates: String, onBackPressed: () -> Unit) {
    Column {
        Spacer(modifier = Modifier
            .statusBarsHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
        )
        TopAppBar(
            title = {
                Text(
                    text = if (selectedDates.isEmpty()) "Select Dates"
                            else selectedDates,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            elevation = 0.dp
        )
    }
}





















