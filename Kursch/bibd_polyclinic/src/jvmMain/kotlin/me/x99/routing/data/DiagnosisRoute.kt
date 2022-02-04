package me.x99.routing.data

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.x99.repo.DiagnosisRepo
import model.Diagnosis

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
            val receivedDiagnosis = call.receive(Diagnosis::class)
            call.respond(diagnosisRepo.create(receivedDiagnosis))
        }
    }
}