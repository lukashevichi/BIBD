package me.x99.repo

import me.x99.database.AppointmentTable
import me.x99.database.DepartmentTable
import me.x99.database.DoctorTable
import me.x99.database.PatientTable
import me.x99.database.PatientTable.name
import me.x99.database.PatientTable.surname
import model.Appointment
import model.Department
import model.Doctor
import model.Patient
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class AppointmentRepo {

    suspend fun create(appointment: Appointment) {
        transaction {
            AppointmentTable.insert {
                it[doctorId] = appointment.doctor?.id ?: -1
                it[patientId] = appointment.patient?.id ?: -1
                it[date] = appointment.date
                it[time] = appointment.time
            }
        }
    }

    suspend fun getAll(): List<Appointment> {
        return transaction {
            AppointmentTable.selectAll().toAppointments()
        }
    }

    suspend fun get(id: Int): Appointment? {
        return transaction {
            AppointmentTable.select { AppointmentTable.id eq id }
                .toAppointments().firstOrNull()
        }
    }

    suspend fun getByPatients(patientId: Int): Appointment? {
        return transaction {
            AppointmentTable.select { AppointmentTable.patientId eq patientId }
                .toAppointments().firstOrNull()
        }
    }

    suspend fun delete(id: Int) {
        return transaction {
            AppointmentTable.deleteWhere {
                AppointmentTable.id eq id
            }
        }
    }

    private fun Query.toAppointments() = this.map {
        val doctor = DoctorTable.select(DoctorTable.id eq it[AppointmentTable.doctorId]).map { doctorRow ->
            val department =
                DepartmentTable.select(DepartmentTable.id eq doctorRow[DoctorTable.departmentId])
                    .firstOrNull()?.toDepartment()
            doctorRow.toAppointments(department)
        }.firstOrNull()
        val patient: Patient =
            PatientTable.select(PatientTable.id eq it[AppointmentTable.patientId]).first().toPatient()
        it.toAppointment(doctor, patient)
    }

    private fun ResultRow.toAppointment(doctor: Doctor?, patient: Patient): Appointment {
        return Appointment(
            id = this[AppointmentTable.id].value,
            doctor = doctor,
            patient = patient,
            date = this[AppointmentTable.date],
            time = this[AppointmentTable.time]
        )
    }

    private fun ResultRow.toAppointments(department: Department?): Doctor {
        return Doctor(
            id = this[DoctorTable.id].value,
            name = this[DoctorTable.name],
            surname = this[DoctorTable.surname],
            cabinet = this[DoctorTable.cabinet],
            telephone = this[DoctorTable.telephone],
            department = department
        )
    }

    private fun ResultRow.toPatient(): Patient {
        return Patient(
            id = this[PatientTable.id].value,
//            login = this[login],
//            psw = this[psw],
            name = this[name],
            surname = this[surname]
        )
    }

    private fun ResultRow.toDepartment(): Department {
        return Department(
            id = this[DepartmentTable.id].value,
            specialization = this[DepartmentTable.specialization],
            telephone = this[DepartmentTable.telephone]
        )
    }

}
