package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable

object DepartmentTable : IntIdTable() {
    val specialization = varchar("specialization", 100)
    val telephone = varchar("telephone", 100)
}