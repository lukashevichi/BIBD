package me.x99.routing.data

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.Appointment

fun Route.appointmentRoute(appointmentRepo: me.x99.repo.AppointmentRepo) {

    route("/appointment") {
        get("/{appointmentId}") {
            val appointmentId = call.parameters["appointmentId"]
                ?: throw IllegalArgumentException("Parameter appointment Id not found")
            appointmentRepo.get(appointmentId.toInt())?.let { appointment -> call.respond(appointment) }
        }

        get("/by/patient/{patientId}") {
            val patientId = call.parameters["patientId"] ?: ""
            appointmentRepo.getByPatients(patientId.toInt()).let { appointment -> call.respond(appointment) }
        }

        get("/") {
            call.respond(appointmentRepo.getAll())
        }

        post("/create") {
            val receivedAppointment = call.receive(Appointment::class)
            call.respond(appointmentRepo.create(receivedAppointment))
        }

        delete("/{appointmentId}") {
            val id = call.parameters["id"]?.toInt() ?: error("Invalid delete request")
            appointmentRepo.delete(id)
            call.respond(HttpStatusCode.OK)
        }
    }
}