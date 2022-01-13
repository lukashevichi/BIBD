package me.x99.views

import kotlinx.html.*
import me.x99.model.*


fun <T> HTML.form(empty: T) {

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

    body {

        div("centered") {

            div("form-wrap") {

                div("profile") {
                    h1 {
                        text("Add")
                    }
                    div {

                        button(type = ButtonType.submit) {
                            text("Create")
                        }

                    }
                }

                form("/my-handling-form-page", method = FormMethod.post) {

                    when (empty) {
                        is Appointment -> {
                            div {
                                label("label") { text("Доктор:") }
                                input(type = InputType.text, name = "doctor_id")
                            }
                            div {
                                label("label") { text("Пациент:") }
                                input(type = InputType.text, name = "name")
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