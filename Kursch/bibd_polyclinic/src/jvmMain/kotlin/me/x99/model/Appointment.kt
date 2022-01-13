package me.x99.model

data class Appointment(
    val id: Int,
    val doctor: Doctor?,
    val patient: Patient?,
    val date: String,
    val time: String
){
    constructor() : this(-999, null, null,"", "")
}