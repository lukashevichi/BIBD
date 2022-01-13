package me.x99.full_data

import me.x99.database.AppointmentTable
import org.jetbrains.exposed.sql.insert

fun AppointmentTable.setData() {
    this.insert {
        it[doctorId] = 1
        it[patientId] = 2
        it[date] = "13:00:00"
        it[time] = "28.12.2022"
    }
}