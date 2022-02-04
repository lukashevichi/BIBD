package me.x99.repo

import me.x99.database.PatientTable
import model.Patient
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import kotlin.math.log10

class PatientRepo {
    suspend fun create(patient: Patient) {
        transaction {
            PatientTable.insert {
                it[id] = UUID.randomUUID().hashCode()
//                it[login] = patient.login
//                it[psw] = patient.psw
                it[name] = patient.name
                it[surname] = patient.surname
            }
        }
    }

    suspend fun getAll(): List<Patient> {
        return transaction {
            PatientTable.selectAll().map {
                it.toPatient()
            }
        }
    }

    suspend fun get(id: Int): Patient? {
        return transaction {
            PatientTable.select { PatientTable.id eq id }.map {
                it.toPatient()
            }.firstOrNull()
        }
    }

    private fun ResultRow.toPatient(): Patient {
        return Patient(
            id = this[PatientTable.id].value,
//            login = this[PatientTable.login],
//            psw = this[PatientTable.psw],
            name = this[PatientTable.name],
            surname = this[PatientTable.surname]
        )
    }
}