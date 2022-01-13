package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import java.util.*

object PatientCardTable : IntIdTable() {
    val number = varchar("number", 100)
    val address = varchar("address", 100)
    val telephone = varchar("telephone", 100)
    val dateOfEstablishment = varchar("dateOfEstablishment", 100)
    val diagnosisId: Column<Int> = integer("diagnosisId").references(DiagnosisTable.id)
}