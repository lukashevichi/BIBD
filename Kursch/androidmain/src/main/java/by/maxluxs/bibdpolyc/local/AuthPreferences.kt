package by.maxluxs.polyc.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import by.maxluxs.polyc.data.model.LoggedInUser

class AuthPreferences(context: Context) {

    companion object {
        const val AUTH_PREFS_NAME = "POL_AUTH_PREFS"

        const val ID = "ID"
        const val LOGIN = "LOGIN"
        const val SESSION = "SESSION"

        const val HAD_DATA = "HAD_DATA"

    }

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(AUTH_PREFS_NAME, MODE_PRIVATE)

    fun saveAuth(user: LoggedInUser): Boolean =
        sharedPref.edit {
            putString(ID, user.userId)
            putString(LOGIN, user.displayName)
            putString(SESSION, user.session)
            commit()
        }.run {
            checkAuth()
        }

    fun getAuth(): LoggedInUser {
        return LoggedInUser(
            sharedPref.getString(ID, "") ?: "",
            sharedPref.getString(LOGIN, "") ?: "",
            sharedPref.getString(SESSION, "") ?: "",
        )
    }

    fun checkAuth(): Boolean = sharedPref.getBoolean(HAD_DATA, false)

    fun removeAuth(): Boolean =
        sharedPref.edit {
            clear()
            commit()
        }.run {
            checkAuth()
        }

}