package by.maxluxs.polyc.ui.appointments.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.maxluxs.polyc.data.local.model.toPatient
import by.maxluxs.polyc.data.local.repository.LoginRepository
import by.maxluxs.polyc.data.remote.RemoteApi
import by.maxluxs.polyc.domain.model.Appointment
import by.maxluxs.polyc.domain.model.Patient
import by.maxluxs.polyc.domain.model.localDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AppointmentsViewModel @Inject constructor(
    private val remoteApi: RemoteApi,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    private val _appointments = MutableLiveData<Map<LocalDate, List<Appointment>>>().apply {
        mutableMapOf<LocalDate, List<Appointment>>()
    }
    val appointments: LiveData<Map<LocalDate, List<Appointment>>> = _appointments

    val patient: Patient? get() = loginRepository.user?.toPatient()

    init {
        getAppointments()
    }

    fun getAppointments() {
        viewModelScope.launch(handler) {
            val resp = remoteApi.getMyAppointments(patient?.id.toString())
            val resMap = mutableMapOf<LocalDate, MutableList<Appointment>>()
            resp.forEach {
                it.localDate?.let { date ->
                    if (resMap.containsKey(date).not()) {
                        resMap[date] = mutableListOf()
                    }
                    resMap[date]?.add(it)
                }
            }
            _appointments.postValue(resMap)
        }

    }

}