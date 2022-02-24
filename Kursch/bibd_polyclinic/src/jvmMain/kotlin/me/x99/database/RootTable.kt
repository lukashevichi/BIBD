package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable

object RootTable : IntIdTable() {
    val polyclinicName = varchar("polyclinicName", 100)
    val address = varchar("address", 100)
    val telephone = varchar("telephone", 100)
}