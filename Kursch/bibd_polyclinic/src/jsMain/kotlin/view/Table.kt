package view

import kotlinx.html.*

fun HTML.table() {


    head {
        meta(charset = "UTF-8")
        meta(content = "IE=edge") {
            httpEquiv = "X-UA-Compatible"
        }
        meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
        link(rel = "preconnect", href = "https://fonts.googleapis.com")
        link(rel = "preconnect", href = "https://fonts.gstatic.com", type = "crossorigin")
        link(
            href = "https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;0,600;0,700;0,800;1,500;1,600;1,700&display=swap",
            rel = "stylesheet"
        )

        link(rel = "stylesheet", href = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css")
        link(
            rel = "stylesheet",
            type = "text/css",
            href = "https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css"
        )
        link(rel = "stylesheet", type = "text/css", href = "css/style.css")


        title = "Table"
    }

    body {

        div("container") {

            nav("navigation") {
                a("index.html", "navigation__logo") { text("Hospital CRM") }
                ul("navigation__list") {
                    li("navigation__list-item")
                    a("navigation-link", "navigation__logo") { text("Hospital CRM") }
                    a("navigation-link", "index.html") { text("Home") }
                    li("navigation__list-item")
                    a("navigation-link", "#") { text("Table") }
                }
            }

            div("mt-5 mb-5") {
                button(name = "btn btn-primary add-data-btn") {
                    id = "add-data-button"
                    text("Add Data")
                }
            }

            div {

                table("display") {
                    id = "table_id"
                    thead {
                        tr("Column") {}
                        tr("Column") {}
                        tr("Column") {}
                    }

                    tbody {

                        tr {
                            td("Data") {}
                            td("Data") {}
                            td("Data") {}
                        }

                        tr {
                            td("Data") {}
                            td("Data") {}
                            td("Data") {}
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
        script {
            src = "../javaScript/app.js"
        }

    }

}