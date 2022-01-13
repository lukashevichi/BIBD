package me.x99

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import me.x99.database.DatabaseFactory
import me.x99.repo.*
import me.x99.routing.*
import me.x99.routing.data.appointmentRoute
import me.x99.routing.data.doctorRoute
import me.x99.routing.data.patientRoute
import me.x99.routing.view.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module(testing: Boolean = false) {

    install(DefaultHeaders)
    install(StatusPages) {
        exception<Throwable> { cause ->
            call.respondText(cause.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
        }
    }
    install(ContentNegotiation) {
        gson {

        }
    }

    DatabaseFactory.init()
    install(Routing) {
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

