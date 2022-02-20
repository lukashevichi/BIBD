package by.maxluxs.polyc.data.local.repository

import by.maxluxs.polyc.data.local.model.Result
import by.maxluxs.polyc.data.local.model.LoggedInUser
import by.maxluxs.polyc.data.remote.RemoteApi
import model.Patient
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

    suspend fun login(
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
                    name,
                    surname
                )
            )


            val fakeUser = LoggedInUser(
                id,
                username,
                name,
                surname,
                password,
                randomUUID().toString()
            )

            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}