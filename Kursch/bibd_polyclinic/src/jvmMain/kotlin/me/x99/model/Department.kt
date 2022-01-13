package me.x99.model

data class Department(
    val id: Int,
    val specialization: String,
    val telephone: String
){
    constructor() : this(-999, "", "")
}