package me.x99.model

data class Patient(
    val id: Int,
    val name: String,
    val surname: String
){
    constructor() : this(-999, "", "")
}