package by.maxluxs.polyc.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.maxluxs.polyc.data.local.repository.LoginRepository
import by.maxluxs.polyc.data.remote.RemoteApi
import by.maxluxs.polyc.domain.model.Root
import by.maxluxs.polyc.ui.appointment.domain.AppointmentReqModel
import by.maxluxs.polyc.ui.home.domain.HomeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteApi: RemoteApi,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    private val _models = MutableLiveData<HomeModel>()
    val models: LiveData<HomeModel> = _models

    private val _root = MutableLiveData<Root>()
    val root: LiveData<Root> = _root

    init {
        getModel()
        getRoot()
    }

    private fun getRoot() {
        viewModelScope.launch(handler) {
            val resp = remoteApi.getRoot()
            _root.postValue(resp.firstOrNull())
        }
    }

    private fun getModel() {
        viewModelScope.launch(handler) {
            val appointmentsResponse =
                remoteApi.getMyAppointments(loginRepository.user?.id.toString())
            val newsResponse = emptyList<String>()
            _models.postValue(
                HomeModel(
                    appointments = appointmentsResponse,
                    news = newsResponse
                )
            )
        }
    }
}