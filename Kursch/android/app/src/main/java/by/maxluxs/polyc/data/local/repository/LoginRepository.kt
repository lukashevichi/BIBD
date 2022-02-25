package by.maxluxs.polyc.data.local.repository

import by.maxluxs.polyc.data.local.model.Result
import by.maxluxs.polyc.data.local.model.LoggedInUser
import by.maxluxs.polyc.data.local.preferences.AuthPreferences
import javax.inject.Inject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository @Inject constructor(
    private val dataSource: LoginDataSource,
    private val authPreferences: AuthPreferences
) {

    // in-memory cache of the loggedInUser object
    val user: LoggedInUser? get() = authPreferences.getAuth()

    val isLoggedIn: Boolean
        get() = user != null

    fun logout() {
        authPreferences.removeAuth()
        dataSource.logout()
    }

    suspend fun login(
        email: String,
        password: String,
    ): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(email, password)
        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    suspend fun reg(
        email: String,
        password: String,
        name: String,
        surname: String
    ): Result<LoggedInUser> {
        // handle login
        val result = dataSource.reg(email, password, name, surname)
        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        authPreferences.saveAuth(loggedInUser)
    }
}