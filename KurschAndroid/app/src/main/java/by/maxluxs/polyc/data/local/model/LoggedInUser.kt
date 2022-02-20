package by.maxluxs.polyc.data.local.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val id: Int,
    val username: String,
    val name: String,
    val surname: String,
    val password: String,
    val session: String
)