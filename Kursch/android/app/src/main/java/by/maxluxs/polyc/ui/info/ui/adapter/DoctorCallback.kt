package by.maxluxs.polyc.ui.info.ui.adapter

import by.maxluxs.polyc.domain.model.Doctor
import by.maxluxs.polyc.ui.info.domain.InfoModel
import model.Department

/**
 *
 * */
interface DoctorCallback {
    fun onClickDoctorItem(model: Doctor)
}
interface DepartmentCallback {
    fun onClickDoctorItem(model: Department)
}