package me.x99.routing.data

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.x99.repo.PatientRepo
import model.Patient

fun Route.patientRoute(patientRepo: PatientRepo) {
    route("/patient") {

        get("/") {
            call.respond(patientRepo.getAll())
        }

        get("/{patientId}") {
            val patientId = call.parameters["patientId"]
                ?: throw IllegalArgumentException("Parameter patient id not found")

            patientRepo.get(patientId.toInt())?.let { patient -> call.respond(patient) } ?: kotlin.run {
                call.respond("patient not found")
            }
        }

        post("/create") {
            val receivedUser = call.receive(Patient::class)
            call.respond(HttpStatusCode.Created, patientRepo.create(receivedUser))
        }

        get("/{login}/{psw}") {
            val login = call.parameters["login"]
                ?: throw IllegalArgumentException("Parameter patient email not found")

            val psw = call.parameters["psw"]
                ?: throw IllegalArgumentException("Parameter patient email not found")

            patientRepo.get(login = login, psw = psw)
                ?.let { patient -> call.respond(patient) }
                ?: kotlin.run {
                    call.respond(HttpStatusCode.NoContent, "patient not found")
                }
        }
    }
}