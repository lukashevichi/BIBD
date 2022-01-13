package me.x99.model

data class Doctor(
    val id: Int,
    val name: String,
    val surname: String,
    val cabinet: String,
    val telephone: String,
    val department: Department?
){
    constructor() : this(-999, "", "", "", "", Department())
}