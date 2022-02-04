package me.x99

import io.ktor.server.application.*
import me.x99.application.configureAdministration
import me.x99.application.configureRouting
import me.x99.application.configureSecurity
import me.x99.application.configureSerialization
import me.x99.database.DatabaseFactory

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module(testing: Boolean = false) {
    DatabaseFactory.init()
    configureSecurity()
    configureAdministration()
    configureSerialization()
    configureRouting()
}

