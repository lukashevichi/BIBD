package by.maxluxs.polyc.ui.appointment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.maxluxs.polyc.data.local.repository.LoginRepository
import by.maxluxs.polyc.data.remote.RemoteApi
import by.maxluxs.polyc.domain.model.Appointment
import by.maxluxs.polyc.domain.model.Doctor
import by.maxluxs.polyc.domain.model.Patient
import by.maxluxs.polyc.ui.appointment.domain.AppointmentReqModel
import by.maxluxs.polyc.ui.info.domain.InfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AppointmentViewModel @Inject constructor(
    private val remoteApi: RemoteApi,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    private val _models = MutableLiveData<AppointmentReqModel>()
    val models: LiveData<AppointmentReqModel> = _models

    private val _selectedDoctor = MutableLiveData<Doctor>()
    val selectedDoctor: LiveData<Doctor> = _selectedDoctor
    fun setDoctor(doctor: Doctor) = _selectedDoctor.postValue(doctor)

    private val _selectedPatient = MutableLiveData<Patient>()
    val selectedPatient: LiveData<Patient> = _selectedPatient
    fun setPatient(patient: Patient) = _selectedPatient.postValue(patient)

    private val _selectedDate = MutableLiveData<String>()
    val selectedDate: LiveData<String> = _selectedDate
    fun setDate(date: String) = _selectedDate.postValue(date)

    private val _selectedTime = MutableLiveData<String>()
    val selectedTime: LiveData<String> = _selectedTime
    fun setTime(date: String) = _selectedTime.postValue(date)

    private val _createdEvent = MutableLiveData<Boolean>()
    val createdEvent: LiveData<Boolean> = _createdEvent

    private val _errorEvent = MutableLiveData<String>()
    val errorEvent: LiveData<String> = _errorEvent

    init {
        getModel()
    }

    private fun getModel() {
        viewModelScope.launch(handler) {
            val doctorsResponse = remoteApi.getDoctors()
            _models.postValue(
                AppointmentReqModel(doctors = doctorsResponse,)
            )
        }
    }

    fun addAppointment() {
        val isValid = selectedDoctor.value != null
                && selectedPatient.value != null
                && selectedDate.value != null
                && selectedTime.value != null
        if (isValid) {
            val appointment = Appointment(
                id = Random().nextInt(999999999),
                doctor = selectedDoctor.value,
                patient = selectedPatient.value,
                date = selectedDate.value ?: "",
                time = selectedTime.value ?: ""
            )
            viewModelScope.launch(handler) {
                val response = remoteApi.createAppointment(appointment)
                _createdEvent.postValue(true)
            }
        } else {
            _errorEvent.postValue("Не верные данные!")
        }

    }

}