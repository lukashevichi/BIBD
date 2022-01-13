package me.x99.repo

import me.x99.database.DepartmentTable
import me.x99.database.DoctorTable
import me.x99.model.Department
import me.x99.model.Doctor
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class DoctorRepo {
    suspend fun create(doctor: Doctor) {
        transaction {
            DoctorTable.insert {
                it[name] = doctor.name
                it[surname] = doctor.surname
                it[cabinet] = doctor.cabinet
                it[telephone] = doctor.telephone
                it[departmentId] = doctor.department?.id ?: -1
            }
        }
    }

    suspend fun getAll(): List<Doctor> {
        return transaction {
            DoctorTable.selectAll().toDoctors()
        }
    }

    suspend fun get(id: Int): Doctor? {
        return transaction {
            DoctorTable.select { DoctorTable.id eq id }.toDoctors().firstOrNull()
        }
    }

    private fun Query.toDoctors() = this.map {
        val department =
            DepartmentTable.select(DepartmentTable.id eq it[DoctorTable.departmentId])
                .firstOrNull()?.toDepartment()
        it.toDoctor(department)
    }

    private fun ResultRow.toDepartment(): Department {
        return Department(
            id = this[DepartmentTable.id].value,
            specialization = this[DepartmentTable.specialization],
            telephone = this[DepartmentTable.telephone]
        )
    }

    private fun ResultRow.toDoctor(department: Department?): Doctor {
        return Doctor(
            id = this[DoctorTable.id].value,
            name = this[DoctorTable.name],
            surname = this[DoctorTable.surname],
            cabinet = this[DoctorTable.cabinet],
            telephone = this[DoctorTable.telephone],
            department = department
        )
    }
}