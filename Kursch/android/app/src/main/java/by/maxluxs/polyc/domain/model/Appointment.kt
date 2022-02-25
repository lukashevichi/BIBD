package by.maxluxs.polyc.domain.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Appointment(
    @SerializedName("id") val id: Int,
    @SerializedName("doctor") val doctor: Doctor?,
    @SerializedName("patient") val patient: Patient?,
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String
)

val Appointment.localDate: LocalDate?
    get() = LocalDate.parse(date)
