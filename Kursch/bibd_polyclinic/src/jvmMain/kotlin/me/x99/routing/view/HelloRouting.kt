package me.x99.routing.view

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import me.x99.views.hello.index

fun Route.helloRouting() {
    route("/") {
        get("/") {
            call.respondHtml(HttpStatusCode.OK) { index() }
        }
        static("/static") {
            resources("css")
            resources("images")
        }
    }
}