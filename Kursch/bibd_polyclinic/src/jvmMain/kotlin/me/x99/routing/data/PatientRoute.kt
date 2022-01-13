package me.x99.routing.data

import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import me.x99.repo.PatientRepo

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
            val receivedUser = call.receive(me.x99.model.Patient::class)
            call.respond(patientRepo.create(receivedUser))
        }
    }
}