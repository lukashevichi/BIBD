package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable

object PatientTable : IntIdTable() {
    val login = varchar("login", 100)
    val psw = varchar("psw", 100)
    val name = varchar("name", 100)
    val surname = varchar("surname", 100)
}