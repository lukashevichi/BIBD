package me.x99.routing.data

import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import me.x99.repo.DoctorRepo

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
            val receivedDoctor = call.receive(me.x99.model.Doctor::class)
            call.respond(doctorRepo.create(receivedDoctor))
        }
    }
}