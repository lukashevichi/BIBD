package by.maxluxs.polyc.data.local.repository

import android.util.Log
import by.maxluxs.polyc.data.local.model.Result
import by.maxluxs.polyc.data.local.model.LoggedInUser
import by.maxluxs.polyc.data.remote.RemoteApi
import by.maxluxs.polyc.domain.model.Patient
import java.io.IOException
import java.util.*
import java.util.UUID.*
import javax.inject.Inject

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource @Inject constructor(
    private val remoteApi: RemoteApi,
) {

    suspend fun reg(
        username: String,
        password: String,
        name: String,
        surname: String
    ): Result<LoggedInUser> {
        try {
            val id = Random().nextInt(999999999)
            val response = remoteApi.signUp(
                Patient(
                    id,
                    username,
                    password,
                    name,
                    surname,
                )
            )
            val user = LoggedInUser(
                id,
                username,
                name,
                surname,
                password,
                randomUUID().toString()
            )
            return Result.Success(user)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    suspend fun login(
        username: String,
        password: String,
    ): Result<LoggedInUser> {
        return try {
            val response = remoteApi.signIn(username, password)
            val user = LoggedInUser(
                response.id,
                response.login,
                response.name,
                response.surname,
                response.password,
                randomUUID().toString()
            )
            Result.Success(user)
        } catch (e: Throwable) {
            Log.e("!!!", e.toString())
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}