package view

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
        link {
            rel = "preconnect"
            href = "https://fonts.googleapis.com"
        }
        link("https://fonts.gstatic.com", "preconnect", "crossorigin")

        link(
            "https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,700;0,800;1,500;1,600;1,700&display=swap",
            "stylesheet"
        )

        link("https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css", "stylesheet")

        link(href = "https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css", "stylesheet", "text/css")

        link("css/style.css", "stylesheet", "text/css")

        title = "Welcome"


    }

    body {

        div {
            id = "root"
        }

        div {
            classes = setOf("container")

            nav {
                classes = setOf("navigation")
                a("navigation__logo", "/index.html") {
                    text("Hospital CRM")
                }

                ul("navigation__list") {
                    li("navigation__list-item") {
                        a("navigation-link", "/index.html") {
                            text("Home")
                        }
                    }

                    li("navigation__list-item") {
                        a("navigation-link", "table.html") {
                            text("Home")
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
                        text(" Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis corrupti repellendus nulla eius distinctio officiis vitae consequatur quis nobis, sequi quisquam corporis ea accusantium porro quod nostrum modi necessitatibus. Dicta amet velit tempore illo quasi eos, est odio modi aspernatur!")
                    }
                }
                div {
                    div {
                        img("main-image") {
                            src = "images/hospital.jpeg"
                        }
                    }

                }

                section("section mt-5 appointment") {
                    div("appointment-block") {
                        h2("appointment-title") {
                            text("You can make an appointment right here!")
                        }
                        p("appointment-text") {
                            text("Lorem ipsum dolor sit amet, consectetur adipisicing elit.\n")
                        }
                    }
                    a(href = "table.html", classes = "appointment-button") {
                        text("make an appointment")
                    }

                }

            }

        }

        script(src = "/static/untitled.js") {}

    }

}
