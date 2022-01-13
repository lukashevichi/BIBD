package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable

object DiagnosisTable : IntIdTable() {
    val name = varchar("name", 100)
}
