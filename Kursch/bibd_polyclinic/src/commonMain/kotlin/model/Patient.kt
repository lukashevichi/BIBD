package model

data class Patient(
    val id: Int,
//    val login: String,
//    val psw: String,
//
    val name: String,
    val surname: String
){
    constructor() : this(-999, "", "")
}