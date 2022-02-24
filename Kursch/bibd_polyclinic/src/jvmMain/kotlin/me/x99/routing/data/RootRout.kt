package me.x99.routing.data

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.x99.repo.RootRepo
import model.Root

fun Route.rootRout(rootRepo: RootRepo) {
    route("/root") {

        get("/") {
            call.respond(rootRepo.getAll())
        }

        get("/{rootId}") {
            val doctorId = call.parameters["rootId"]
                ?: throw IllegalArgumentException("Parameter user id not found")

            rootRepo.get(doctorId.toInt())?.let { user -> call.respond(user) } ?: kotlin.run {
                call.respond("User not found")
            }
        }

        post("/create") {
            val receivedDoctor = call.receive(Root::class)
            call.respond(rootRepo.create(receivedDoctor))
        }
    }
}