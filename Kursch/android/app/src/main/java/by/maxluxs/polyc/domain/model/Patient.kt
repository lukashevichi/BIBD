package by.maxluxs.polyc.domain.model

import com.google.gson.annotations.SerializedName

data class Patient(
    @SerializedName("id") val id: Int,
    @SerializedName("login") val login: String,
    @SerializedName("psw") val password: String,
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String
)