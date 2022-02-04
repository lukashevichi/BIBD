package me.x99.routing.view

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import me.x99.repo.*
import me.x99.views.form
import model.*

fun Route.addPatientsViewRouting(patientRepo: PatientRepo) {
    route("/add_patients_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                form(Patient())
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.addDoctorsViewRouting(doctorRepo: DoctorRepo) {
    route("/add_doctors_view") {
        get("/") {
            val data = doctorRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                form(Doctor())
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.addPatientCardViewRouting(patientRepo: PatientCardRepo) {
    route("/add_patient_cards_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                form(PatientCard())
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.addAppointmentViewRouting(patientRepo: AppointmentRepo) {
    route("/add_appointment_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                form(Appointment())
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.addDepartmentViewRouting(patientRepo: DepartmentRepo) {
    route("/add_departments_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                form(Department())
            }
        }
        static("/static") {
            resources("css")
        }
    }
}