package by.maxluxs.polyc.domain.model

import by.maxluxs.polyc.data.local.model.LoggedInUser
import model.Department

data class Doctor(
    val id: Int,
    val name: String,
    val surname: String,
    val cabinet: String,
    val telephone: String,
    val department: Department?
)

fun Doctor.initials(): String = name.firstOrNull().toString() + surname.firstOrNull().toString()
