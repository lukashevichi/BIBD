package me.x99.views

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.util.*
import kotlinx.coroutines.*
import kotlinx.html.*
import kotlinx.html.dom.document
import me.x99.database.AppDatabase
import model.*
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import org.w3c.dom.Document
import kotlin.coroutines.CoroutineContext


@OptIn(InternalAPI::class, DelicateCoroutinesApi::class)
fun <T> HTML.form(empty: T) {

    val client = HttpClient {
        BrowserUserAgent()
        defaultRequest {
            host = "127.0.0.1"
            port = 8080
            header("X-My-Header", "MyValue")
        }
    }

    fun getAction() = when (empty) {
        is Appointment -> {
            "/appointment/create"
        }
        is Patient -> {
            "/department/create"
        }
        is Doctor -> {
            "/doctor/create"
        }
        is Department -> {
            "/patientCard/create"
        }
        is PatientCard -> {
            "/patient/create"
        }

        else -> {
            ""
        }
    }

    suspend fun save(document: Document) = when (empty) {
        is Appointment -> {
            val doctorId = document.getElementById("doctor_id")
            val patientId = document.getElementById("patient_id")
//            val date = document.getElementById("date")
//            val time = document.getElementById("time")
//            database.doctorRepo.get(doctorId.textContent.toInt())?.let { doc ->
//                database.patientRepo.get(patientId.textContent.toInt())?.let { pat ->
//                    Appointment(
//                        123,
//                        doc,
//                        pat,
//                        date.textContent,
//                        time.textContent
//                    )
//                    true
//
//                } ?: false
//            } ?: false
            false
        }
        is Patient -> {
            val name = document.getElementById("name")
            val surname = document.getElementById("surname")
            val data = Patient(
                (name.textContent + surname.textContent).hashCode(),
                name.textContent,
                surname.textContent
            )
            val response: HttpResponse = client.post("http://localhost:8080${getAction()}") {
                contentType(ContentType.Application.Json)
                body = data
            }
            true
        }
        is Doctor -> {
            false
        }
        is Department -> {
            false
        }
        is PatientCard -> {
            false
        }
        else -> {
            false
        }
    }

    head {
        meta(charset = "UTF-8")
        meta(content = "IE=edge") {
            httpEquiv = "X-UA-Compatible"
        }
        meta(name = "viewport", content = "width=device-width, initial-scale=1.0")

        styleLink("https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,700;0,800;1,500;1,600;1,700&display=swap")
        styleLink("https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css")
        styleLink("https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css")
        styleLink("https://fonts.gstatic.com")
        styleLink("https://fonts.googleapis.com")

        link("static/style.css", "stylesheet", "text/css")

        title("Table")
    }

    document {

        body {

            div("centered") {

                div("form-wrap") {

                    div("profile") {
                        h1 {
                            text("Add")
                        }
                        div {

                            a("/") {
                                +"Create"
//                                save(this@document)
                            }

                        }
                    }

                    form("/method", method = FormMethod.post) {

                        when (empty) {
                            is Appointment -> {
                                div {
                                    label("label") { text("Доктор:") }
                                    input(type = InputType.text, name = "doctor_id")
                                }
                                div {
                                    label("label") { text("Пациент:") }
                                    input(type = InputType.text, name = "patient_id")
                                }
                                div {
                                    label("label") { text("Дата:") }
                                    input(type = InputType.text, name = "date")
                                }
                                div {
                                    label("label") { text("Время:") }
                                    input(type = InputType.text, name = "time")
                                }
                            }
                            is Patient -> {
                                div {
                                    label("label") { text("Имя:") }
                                    input(type = InputType.text, name = "name")
                                }
                                div {
                                    label("label") { text("Фамилия:") }
                                    input(type = InputType.text, name = "surname")
                                }
                            }
                            is Doctor -> {
                                div {
                                    label("label") { text("Имя:") }
                                    input(type = InputType.text, name = "name")
                                }
                                div {
                                    label("label") { text("Фамилия:") }
                                    input(type = InputType.text, name = "surname")
                                }
                                div {
                                    label("label") { text("Телефон:") }
                                    input(type = InputType.text, name = "telephone")
                                }
                                div {
                                    label("label") { text("Кабинет:") }
                                    input(type = InputType.text, name = "cabinet")
                                }
                                div {
                                    label("label") { text("Специализация:") }
                                    input(type = InputType.text, name = "specialization")
                                }
                            }
                            is Department -> {
                                div {
                                    label("label") { text("Специализация:") }
                                    input(type = InputType.text, name = "specialization")
                                }
                                div {
                                    label("label") { text("Телефон:") }
                                    input(type = InputType.text, name = "telephone")
                                }
                            }
                            is PatientCard -> {
                                div {
                                    label("label") { text("Номер:") }
                                    input(type = InputType.text, name = "number")
                                }
                                div {
                                    label("label") { text("Адрес:") }
                                    input(type = InputType.text, name = "address")
                                }
                                div {
                                    label("label") { text("Телефон:") }
                                    input(type = InputType.text, name = "telephone")
                                }
                                div {
                                    label("label") { text("Дата заведения:") }
                                    input(type = InputType.text, name = "date")
                                }
                                div {
                                    label("label") { text("Диагноз:") }
                                    input(type = InputType.text, name = "diagnosis")
                                }
                            }

                        }

                    }

                }
            }
        }
    }

}