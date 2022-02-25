package by.maxluxs.polyc.ui.home.adapter

import by.maxluxs.polyc.domain.model.Appointment

/**
 *
 * */
interface AppointmentCallback {
    fun onClickAppointmentItem(model: Appointment)
}