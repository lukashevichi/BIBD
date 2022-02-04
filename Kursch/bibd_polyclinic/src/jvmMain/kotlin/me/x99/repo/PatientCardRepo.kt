package me.x99.repo

import me.x99.database.DiagnosisTable
import me.x99.database.PatientCardTable
import model.Diagnosis
import model.PatientCard
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class PatientCardRepo {
    suspend fun create(patientCard: PatientCard) {
        transaction {
            PatientCardTable.insert {
                it[address] = patientCard.address
                it[telephone] = patientCard.telephone
                it[number] = patientCard.number
                it[dateOfEstablishment] = patientCard.dateOfEstablishment
                it[diagnosisId] = patientCard.diagnosis?.id ?: -1
            }
        }
    }

    suspend fun getAll(): List<PatientCard> {
        return transaction {
            PatientCardTable.selectAll().toCards()
        }
    }

    suspend fun get(id: Int): PatientCard? {
        return transaction {
            PatientCardTable.select(PatientCardTable.id eq id).toCards().firstOrNull()
        }
    }

    private fun Query.toCards() = this.map { patientRow ->
        val diagnosis =
            DiagnosisTable.select(DiagnosisTable.id eq patientRow[PatientCardTable.diagnosisId]).firstOrNull()
                ?.toDiagnosis()
        patientRow.toPatientCard(diagnosis)
    }

    private fun ResultRow.toDiagnosis(): Diagnosis {
        return Diagnosis(
            id = this[DiagnosisTable.id].value,
            name = this[DiagnosisTable.name],
        )
    }

    private fun ResultRow.toPatientCard(diagnosis: Diagnosis?): PatientCard {
        return PatientCard(
            id = this[PatientCardTable.id].value,
            number = this[PatientCardTable.number],
            address = this[PatientCardTable.address],
            telephone = this[PatientCardTable.telephone],
            dateOfEstablishment = this[PatientCardTable.dateOfEstablishment],
            diagnosis = diagnosis
        )
    }
}