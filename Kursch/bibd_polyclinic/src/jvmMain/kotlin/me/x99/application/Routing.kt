package me.x99.application

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.routing.*
import me.x99.repo.*
import me.x99.routing.data.appointmentRoute
import me.x99.routing.data.doctorRoute
import me.x99.routing.data.patientRoute
import me.x99.routing.data.departmentRoute
import me.x99.routing.data.diagnosisRoute
import me.x99.routing.data.patientCardRoute
import me.x99.routing.view.*

fun Application.configureRouting() {
    install(AutoHeadResponse)
    routing {
        //view
        helloRouting()
        patientsViewRouting(PatientRepo())
        doctorsViewRouting(DoctorRepo())
        patientCardViewRouting(PatientCardRepo())
        appointmentCardViewRouting(AppointmentRepo())
        departmentViewRouting(DepartmentRepo())
        //data
        appointmentRoute(AppointmentRepo())
        departmentRoute(DepartmentRepo())
        diagnosisRoute(DiagnosisRepo())
        doctorRoute(DoctorRepo())
        patientCardRoute(PatientCardRepo())
        patientRoute(PatientRepo())
        //add
        addPatientCardViewRouting(PatientCardRepo())
        addAppointmentViewRouting(AppointmentRepo())
        addDepartmentViewRouting(DepartmentRepo())
        addPatientsViewRouting(PatientRepo())
        addDoctorsViewRouting(DoctorRepo())
    }
}
