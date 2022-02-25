package by.maxluxs.polyc.data.remote

import by.maxluxs.polyc.domain.model.Appointment
import by.maxluxs.polyc.domain.model.Patient
import by.maxluxs.polyc.domain.model.Doctor
import by.maxluxs.polyc.domain.model.Root
import model.Department
import retrofit2.http.*

interface RemoteApi {

    @POST("/patient/create")
    suspend fun signUp(
        @Body patient: Patient
    )

    @GET("/patient/{login}/{psw}")
    suspend fun signIn(
        @Path("login") login: String,
        @Path("psw") psw: String
    ): Patient

    @GET("/appointment/by/patient/{patientId}")
    suspend fun getMyAppointments(
        @Path("patientId") patientId: String
    ): List<Appointment>

    @GET("/doctor/")
    suspend fun getDoctors(): List<Doctor>

    @GET("/root/")
    suspend fun getRoot(): List<Root>

    @GET("/department/")
    suspend fun getDepartment(): List<Department>

    @GET("/patient/{patientId}")
    suspend fun getPatient(@Path("patientId") patientId: String): List<Patient>

    @POST("/appointment/create")
    suspend fun createAppointment(@Body appointment: Appointment): Patient

}