package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object AppointmentTable : IntIdTable() {
    val doctorId: Column<Int> = integer("doctorId").references(DoctorTable.id)
    val patientId: Column<Int> = integer("patientId").references(PatientTable.id)
    val date = varchar("date", 100)
    val time = varchar("time", 100)
}