package by.maxluxs.polyc.data.remote

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import model.Patient
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RemoteApi {

    @POST("/patient/create")
    suspend fun signUp(
        @Body patient: Patient
    )

    @GET("/appointment/by/patient{patientId}")
    suspend fun getMyAppointments(
        @Path("patientId") patientId: String
    )

}