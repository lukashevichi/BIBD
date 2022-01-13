package me.x99.routing

import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import me.x99.repo.DepartmentRepo

fun Route.departmentRoute(departmentRepo: DepartmentRepo) {
    route("/department") {

        get("/") {
            call.respond(departmentRepo.getAll())
        }

        get("/{departmentId}") {
            val departmentId = call.parameters["departmentId"]
                    ?: throw IllegalArgumentException("Parameter user id not found")

            departmentRepo.get(departmentId.toInt())?.let { department -> call.respond(department) } ?: kotlin.run {
                call.respond("User not found")
            }
        }

        post("/create") {
            val receivedDepartment = call.receive(me.x99.model.Department::class)
            call.respond(departmentRepo.create(receivedDepartment))
        }
    }
}