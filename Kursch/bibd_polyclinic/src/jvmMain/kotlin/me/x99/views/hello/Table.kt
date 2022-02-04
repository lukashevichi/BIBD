package me.x99.views.hello

import kotlinx.html.*
import model.*

fun <T> HTML.table(
    patients: List<T>
) {

    val buttonHref = when (patients.first()) {
        is Appointment -> {
            "/add_appointment_view/"
        }
        is Patient -> {
            "/add_patients_view/"
        }
        is Doctor -> {
            "/add_doctors_view/"
        }
        is Department -> {
            "/add_departments_view/"
        }
        is PatientCard -> {
            "/add_patient_cards_view/"
        }
        else -> "/"
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

    body {

        div("container") {

            div { id = "table" }

            nav("navigation") {
                a("/", classes = "navigation__logo") { text("Hospital CRM") }
                ul("navigation__list") {
                    li("navigation__list-item") {
                        a("/", classes = "navigation-link") { text("Home") }
                    }
                }
            }

            div("mt-5 mb-5") {
                a(href = buttonHref, classes = "btn btn-primary add-data-btn") {
                    id = "add-data-button"
                    text("Add Data")
                }
            }

            div("") {

                table("display") {
                    id = "table_id"
                    thead {
                        tr {
                            th {
                                colSpan = patients.size.toString()
                            }
                        }
                        tr {

                            when (patients.first()) {
                                is Appointment -> {
                                    th { +"Доктор" }
                                    th { +"Пациент" }
                                    th { +"Дата" }
                                    th { +"Время" }
                                }
                                is Patient -> {
                                    th { +"Имя" }
                                    th { +"Фамилия" }
                                }
                                is Doctor -> {
                                    td { +"Имя" }
                                    td { +"Фамилия" }
                                    td { +"Телефон" }
                                    td { +"Кабинет" }
                                    td { +"Специализация" }
                                }
                                is Department -> {
                                    td { +"Специализация" }
                                    td { +"Телефон" }
                                }
                                is PatientCard -> {
                                    td { +"Номер" }
                                    td { +"Адрес" }
                                    td { +"Телефон" }
                                    td { +"Дата заведения" }
                                    td { +"Диагноз" }
                                }

                            }

                        }
                    }
                    tbody {
                        patients.forEach {
                            tr {

                                when (it) {
                                    is Appointment -> {
                                        td { +"${it.doctor?.name} ${it.doctor?.surname}" }
                                        td { +"${it.patient?.name} ${it.patient?.surname}" }
                                        td { +it.date }
                                        td { +it.time }
                                    }
                                    is Patient -> {
                                        td { +it.name }
                                        td { +it.surname }
                                    }
                                    is Doctor -> {
                                        td { +it.name }
                                        td { +it.surname }
                                        td { +it.telephone }
                                        td { +it.cabinet }
                                        td {
                                            it.department?.specialization?.let { +it } ?: +""
                                        }
                                    }
                                    is Department -> {
                                        td { +it.specialization }
                                        td { +it.telephone }
                                    }
                                    is PatientCard -> {
                                        td { +it.number }
                                        td { +it.address }
                                        td { +it.telephone }
                                        td { +it.dateOfEstablishment }
                                        td {
                                            it.diagnosis?.name?.let { +it } ?: +""
                                        }
                                    }
                                }

                            }

                        }
                    }

                }
            }
        }

        script {
            src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
        }

        script {
            src = "https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"
        }

    }

}