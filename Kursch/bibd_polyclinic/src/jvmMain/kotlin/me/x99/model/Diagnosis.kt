package me.x99.model

data class Diagnosis(
    val id: Int,
    val name: String
){
    constructor() : this(-999, "")
}