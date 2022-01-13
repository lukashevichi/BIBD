package me.x99.views.hello

import kotlinx.html.*

fun HTML.index() {

    head {
        meta {
            charset = "UTF-8"
        }
        meta {
            httpEquiv = "X-UA-Compatible"
            content = "IE=edge"
        }
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1.0"
        }

        styleLink("https://fonts.googleapis.com")
        styleLink("https://fonts.gstatic.com")
        styleLink("https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,700;0,800;1,500;1,600;1,700&display=swap")
        styleLink("https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css")
        styleLink("https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css")

        link("static/style.css", "stylesheet", "text/css")

        title("Welcome")

    }

    body {

        div { id = "root" }

        div("container") {

            nav("navigation") {

                a("/", classes = "navigation__logo") {
                    text("Hospital CRM")
                }

                ul("navigation__list") {

                    li("navigation__list-item") {
                        a("/patients_view/", classes = "navigation-link") {
                            text("Patients")
                        }
                    }

                    li("navigation__list-item") {
                        a("/doctors_view/", classes = "navigation-link") {
                            text("Doctors")
                        }
                    }
                    li("navigation__list-item") {
                        a("/patient_cards_view/", classes = "navigation-link") {
                            text("Patient cards")
                        }
                    }

                    li("navigation__list-item") {
                        a("/appointment_view/", classes = "navigation-link") {
                            text("Appointments")
                        }
                    }

                    li("navigation__list-item") {
                        a("/departments_view/", classes = "navigation-link") {
                            text("Departments")
                        }
                    }

                }

            }

            section("section mt-5 intro") {
                div("welcome-block") {
                    h1("welcome-title") {
                        text("Welcome to our Hospital CRM")
                    }
                    p("welcome-text") {
                        text("In the Healthcare Institution \"999th City Polyclinic\" on the basis of the order of the Ministry of Health, on the basis of the health department of the city of Visk, State Institution \"Hygiene Center\" \"On the vaccination of children against COVID-19 infection\" dated December 24, 2021. No. 224/166 dated December 27. Children aged 12-17 are being vaccinated against COVID-19 infection for children aged 12-17 with a vaccine manufactured by Ver-s. 9999999.")
                    }
                }
                div {
                    div {
                        img("main-image", classes = "main-image") {
                            src = "static/hospital.jpeg"
                        }
                    }
                }
            }

                section("section mt-5 appointment") {
                    div("appointment-block") {
                        h2("appointment-title") {
                            text("You can make an appointment right here!")
                        }
                        p("appointment-text") {
                            text("To register, click the form and fill in the data.\n")
                        }
                    }
                    a(href = "/add_appointment_view/", classes = "appointment-button") {
                        text("make an appointment")
                    }

            }

        }

//        script(src = "/static/untitled.js") {}

    }

}