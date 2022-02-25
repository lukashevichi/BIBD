package by.maxluxs.polyc.data.local.model

import by.maxluxs.polyc.domain.model.Patient

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val id: Int,
    val email: String,
    val name: String,
    val surname: String,
    val password: String,
    val session: String
)

fun LoggedInUser.initials(): String = name.firstOrNull().toString() + surname.firstOrNull().toString()

fun LoggedInUser.toPatient() = Patient(
    id = this.id,
    login = this.email,
    password = this.password,
    name = this.name,
    surname = this.surname
)
