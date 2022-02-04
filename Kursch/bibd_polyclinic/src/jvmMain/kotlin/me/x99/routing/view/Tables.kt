package me.x99.routing.view

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import me.x99.repo.*
import me.x99.views.hello.table

fun Route.patientsViewRouting(patientRepo: PatientRepo) {
    route("/patients_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                table(data)
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.doctorsViewRouting(doctorRepo: DoctorRepo) {
    route("/doctors_view") {
        get("/") {
            val data = doctorRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                table(data)
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.patientCardViewRouting(patientRepo: PatientCardRepo) {
    route("/patient_cards_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                table(data)
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.appointmentCardViewRouting(patientRepo: AppointmentRepo) {
    route("/appointment_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                table(data)
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

fun Route.departmentViewRouting(patientRepo: DepartmentRepo) {
    route("/departments_view") {
        get("/") {
            val data = patientRepo.getAll()
            call.respondHtml(HttpStatusCode.OK) {
                table(data)
            }
        }
        static("/static") {
            resources("css")
        }
    }
}

