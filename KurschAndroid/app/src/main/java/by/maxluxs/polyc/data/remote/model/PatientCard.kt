package model

data class PatientCard(
    val id: Int,
    val number: String,
    val address: String,
    val telephone: String,
    val dateOfEstablishment: String,
    val diagnosis: Diagnosis?
){
    constructor() : this(-999, "", "", "", "", Diagnosis())
}