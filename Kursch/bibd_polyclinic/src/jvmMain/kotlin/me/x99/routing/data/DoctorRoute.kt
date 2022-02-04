package me.x99.routing.data

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.x99.repo.DoctorRepo
import model.Doctor

fun Route.doctorRoute(doctorRepo: DoctorRepo) {
    route("/doctor") {

        get("/") {
            call.respond(doctorRepo.getAll())
        }

        get("/{doctorId}") {
            val doctorId = call.parameters["doctorId"]
                ?: throw IllegalArgumentException("Parameter user id not found")

            doctorRepo.get(doctorId.toInt())?.let { user -> call.respond(user) } ?: kotlin.run {
                call.respond("User not found")
            }
        }

        post("/create") {
            val receivedDoctor = call.receive(Doctor::class)
            call.respond(doctorRepo.create(receivedDoctor))
        }
    }
}