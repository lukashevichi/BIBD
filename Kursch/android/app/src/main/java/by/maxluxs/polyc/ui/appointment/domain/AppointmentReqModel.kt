package by.maxluxs.polyc.ui.appointment.domain

import by.maxluxs.polyc.domain.model.Doctor
import by.maxluxs.polyc.domain.model.Patient

data class AppointmentReqModel(
    val doctors: List<Doctor>,
)