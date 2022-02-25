package by.maxluxs.polyc.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.maxluxs.polyc.data.remote.RemoteApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import by.maxluxs.polyc.ui.info.domain.InfoModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val remoteApi: RemoteApi
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    private val _models = MutableLiveData<InfoModel>()
    val models: LiveData<InfoModel> = _models

    val collapsedDoctorState = MutableLiveData(false)

    val collapsedDepartmentState = MutableLiveData(false)

    init {
        getModel()
    }

    private fun getModel() {
        viewModelScope.launch(handler) {
            val doctorsResponse = remoteApi.getDoctors()
            val departmentResponse = remoteApi.getDepartment()
            _models.postValue(
                InfoModel(
                    doctors = doctorsResponse,
                    departments = departmentResponse
                )
            )
        }
    }
}