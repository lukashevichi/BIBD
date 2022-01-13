package me.x99.database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import java.util.*

object DoctorTable : IntIdTable() {
    val departmentId: Column<Int> = integer("departmentId").references(DepartmentTable.id)
    val name = varchar("name", 100)
    val surname = varchar("surname", 100)
    val cabinet = varchar("cabinet", 100)
    val telephone = varchar("telephone", 100)
}