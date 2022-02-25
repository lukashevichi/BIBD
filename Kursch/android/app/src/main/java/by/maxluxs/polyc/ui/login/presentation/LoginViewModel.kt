package by.maxluxs.polyc.ui.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import by.maxluxs.polyc.data.local.repository.LoginRepository
import by.maxluxs.polyc.data.local.model.Result

import by.maxluxs.polyc.R
import by.maxluxs.polyc.data.remote.RemoteApi
import by.maxluxs.polyc.domain.model.Root
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val remoteApi: RemoteApi
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    private val _root = MutableLiveData<Root>()
    val root: LiveData<Root> = _root

    init {
        getRoot()
    }

    private fun getRoot() {
        viewModelScope.launch(handler) {
            val resp = remoteApi.getRoot()
            _root.postValue(resp.firstOrNull())
        }
    }

    fun reg(email: String, name: String, surname: String, password: String) {
        viewModelScope.launch {
            // can be launched in a separate asynchronous job
            val result = loginRepository.reg(email, password, name, surname)
            if (result is Result.Success) {
                _loginResult.value =
                    LoginResult(success = LoggedInUserView(displayName = result.data.name))
            } else {
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            // can be launched in a separate asynchronous job
            val result = loginRepository.login(email, password)
            if (result is Result.Success) {
                _loginResult.value =
                    LoginResult(success = LoggedInUserView(displayName = result.data.name))
            } else {
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 3
    }
}