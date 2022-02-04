package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable

object PatientTable : IntIdTable() {
//    val login = varchar("name", 100)
//    val psw = varchar("date", 100)
    val name = varchar("name", 100)
    val surname = varchar("date", 100)
}