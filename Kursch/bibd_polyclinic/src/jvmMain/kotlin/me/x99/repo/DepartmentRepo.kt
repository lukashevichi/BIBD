package me.x99.repo

import me.x99.database.DepartmentTable
import model.Department
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class DepartmentRepo {
    suspend fun create(department: Department) {
        transaction {
            DepartmentTable.insert {
                it[specialization] = department.specialization
                it[telephone] = department.telephone
            }
        }
    }

    suspend fun getAll(): List<Department> {
        return transaction {
            DepartmentTable.selectAll().map {
                it.toDepartment()
            }
        }
    }

    suspend fun get(id: Int): Department? {
        return transaction {
            DepartmentTable.select { DepartmentTable.id eq id }.map {
                it.toDepartment()
            }.firstOrNull()
        }
    }

    private fun ResultRow.toDepartment(): Department {
        return Department(
            id = this[DepartmentTable.id].value,
            specialization = this[DepartmentTable.specialization],
            telephone = this[DepartmentTable.telephone]
        )
    }

}