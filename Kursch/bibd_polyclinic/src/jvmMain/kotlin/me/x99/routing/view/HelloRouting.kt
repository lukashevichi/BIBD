package me.x99.routing.view

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.routing.*
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