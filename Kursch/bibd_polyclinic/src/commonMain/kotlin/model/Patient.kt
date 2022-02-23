package model

data class Patient(
    val id: Int,
    val name: String,
    val surname: String,
    val login: String,
    val psw: String
) {
    constructor() : this(-999, "", "", "", "")
}