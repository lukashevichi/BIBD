package me.x99.database

import me.x99.repo.*

class AppDatabase(
    val appointmentRepo: AppointmentRepo,
    val departmentRepo: DepartmentRepo,
    val diagnosisRepo: DiagnosisRepo,
    val doctorRepo: DoctorRepo,
    val patientCardRepo: PatientCardRepo,
    val patientRepo: PatientRepo
)