package me.x99.routing.data

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.x99.repo.PatientCardRepo
import model.PatientCard

fun Route.patientCardRoute(patientCardRepo: PatientCardRepo) {
    route("/patientCard") {

        get("/") {
            call.respond(patientCardRepo.getAll())
        }

        get("/{patientCardId}") {
            val userId = call.parameters["patientCardId"]
                ?: throw IllegalArgumentException("Parameter patientCard id not found")

            patientCardRepo.get(userId.toInt())?.let { patientCard -> call.respond(patientCard) } ?: kotlin.run {
                call.respond("User not found")
            }
        }

        post("/create") {
            val receivedPatientCard = call.receive(PatientCard::class)
            call.respond(patientCardRepo.create(receivedPatientCard))
        }
    }
}