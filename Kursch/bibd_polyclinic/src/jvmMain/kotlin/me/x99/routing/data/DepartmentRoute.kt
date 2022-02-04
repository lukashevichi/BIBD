package me.x99.routing.data

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.x99.repo.DepartmentRepo
import model.Department

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
            val receivedDepartment = call.receive(Department::class)
            call.respond(departmentRepo.create(receivedDepartment))
        }
    }
}