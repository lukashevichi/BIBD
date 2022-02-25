package by.maxluxs.polyc.ui.home.domain

import by.maxluxs.polyc.domain.model.Appointment

data class HomeModel(
    val appointments: List<Appointment>,
    val news: List<String>
)