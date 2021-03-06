package by.maxluxs.polyc.data

import by.maxluxs.polyc.data.model.LoggedInUser
import by.maxluxs.polyc.local.AuthPreferences
import by.maxluxs.polyc.local.AuthRepository

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(
    val dataSource: LoginDataSource,
    val authPreferences: AuthPreferences
) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        authPreferences.saveAuth(loggedInUser)
        this.user = loggedInUser
    }
}