package me.x99.routing

import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import me.x99.model.PatientCard
import me.x99.repo.PatientCardRepo

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
            val receivedPatientCard = call.receive(me.x99.model.PatientCard::class)
            call.respond(patientCardRepo.create(receivedPatientCard))
        }
    }
}