package me.x99.full_data

import me.x99.database.AppointmentTable
import org.jetbrains.exposed.sql.insert

fun AppointmentTable.setData() {
    this.insert {
        it[doctorId] = 1
        it[patientId] = 2
        it[date] = "2022-02-24"
        it[time] = "13:00:00"
    }
    this.insert {
        it[doctorId] = 2
        it[patientId] = 1
        it[date] = "2022-02-24"
        it[time] = "13:00:00"
    }
}