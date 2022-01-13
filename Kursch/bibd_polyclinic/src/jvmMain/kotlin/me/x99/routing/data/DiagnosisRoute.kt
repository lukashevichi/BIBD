package me.x99.routing

import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import me.x99.repo.DiagnosisRepo

fun Route.diagnosisRoute(diagnosisRepo: DiagnosisRepo) {
    route("/diagnosis") {

        get("/") {
            call.respond(diagnosisRepo.getAll())
        }

        get("/{diagnosisId}") {
            val diagnosisId = call.parameters["diagnosisId"]
                ?: throw IllegalArgumentException("Parameter user id not found")

            diagnosisRepo.get(diagnosisId.toInt())?.let { user -> call.respond(user) } ?: kotlin.run {
                call.respond("User not found")
            }
        }

        post("/create") {
            val receivedDiagnosis = call.receive(me.x99.model.Diagnosis::class)
            call.respond(diagnosisRepo.create(receivedDiagnosis))
        }
    }
}