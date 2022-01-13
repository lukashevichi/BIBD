package me.x99.repo

import io.ktor.routing.get
import me.x99.database.DiagnosisTable
import me.x99.model.Diagnosis
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class DiagnosisRepo {
    suspend fun create(diagnosis: Diagnosis) {
        transaction {
            DiagnosisTable.insert {
                it[id] = diagnosis.id
                it[name] = diagnosis.name
            }
        }
    }

    suspend fun getAll(): List<Diagnosis> {
        return transaction {
            DiagnosisTable.selectAll().map {
                it.toDiagnosis()
            }
        }
    }

    suspend fun get(id: Int): Diagnosis? {
        return transaction {
            DiagnosisTable.select { DiagnosisTable.id eq id }.map {
                it.toDiagnosis()
            }.firstOrNull()
        }
    }

    private fun ResultRow.toDiagnosis(): Diagnosis {
        return Diagnosis(
            id = this[DiagnosisTable.id].value,
            name = this[DiagnosisTable.name],
        )
    }

}
