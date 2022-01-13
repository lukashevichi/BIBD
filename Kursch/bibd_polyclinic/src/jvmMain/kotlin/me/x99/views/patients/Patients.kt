package me.x99.views.patients

import kotlinx.html.*
import me.x99.model.Doctor
import me.x99.model.Patient


fun HTML.patientsTable(
    search: String,
    patients: List<Patient>
) {
    head {
        title("Polyclinic patients")
    }
    body {
        table {
            thead {
                tr {
                    th {
                        colSpan = patients.size.toString()
                    }
                }
                tr {
                    th { +"Имя" }
                    th { +"Фамилия" }
                }
            }
            patients.forEach {
                tbody {
                    tr {
                        td { +it.name }
                        td { +it.surname }
                    }
                }
            }
        }
        a("/") {
            +"Go back"
        }
        script(src = "/static/untitled.js") {}
    }
}

fun HTML.doctorsTable(
    search: String,
    doctors: List<Doctor>
) {
    head {
        title("Polyclinic doctors")
    }
    body {
        table {
            thead {
                tr {
                    th {
                        colSpan = doctors.size.toString() //(1)
                        style = """
            border: solid;
            border-color: red;
          """ //(2)
                    }
                }
                tr {
                    th { +"Имя" }
                    th { +"Фамилия" }
                }
            }
            doctors.forEach {
                tbody {
                    tr {
                        td { +it.name }
                        td { +it.surname }
                    }
                }
            }
        }
        a("/") {
            +"Go back"
        }
        script(src = "/static/untitled.js") {}
    }
}