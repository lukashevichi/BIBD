package by.maxluxs.polyc.data.local.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import by.maxluxs.polyc.data.local.model.LoggedInUser
import com.google.gson.Gson
import java.lang.Exception

class AuthPreferences(context: Context) {

    private val gson = Gson()

    companion object {
        const val AUTH_PREFS_NAME = "POL_AUTH_PREFS"
        const val USER = "USER"
        const val HAS_DATA = "HAS_DATA"
    }

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(AUTH_PREFS_NAME, MODE_PRIVATE)

    fun saveAuth(user: LoggedInUser): Boolean =
        sharedPref
            .edit {
                val data = gson.toJson(user)
                putString(USER, data)
                putBoolean(HAS_DATA, true)
                commit()
            }
            .run { checkAuth() }

    fun getAuth(): LoggedInUser? {
        val data = sharedPref.getString(USER, "")
        return try {
            gson.fromJson(data, LoggedInUser::class.java)
        } catch (e: Exception) {
            null
        }
    }

    fun checkAuth(): Boolean = sharedPref.getBoolean(HAS_DATA, false)

    fun removeAuth(): Boolean =
        sharedPref
            .edit {
                clear()
                commit()
            }
            .run { checkAuth() }

}