package model

data class Patient(
    val id: Int,
    val name: String,
    val surname: String
){
    constructor() : this(-999, "", "")
}