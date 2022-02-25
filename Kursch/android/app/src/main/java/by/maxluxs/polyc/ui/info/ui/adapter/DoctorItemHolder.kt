package by.maxluxs.polyc.ui.info.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.polyc.databinding.ItemDepartmentBinding
import by.maxluxs.polyc.databinding.ItemDoctorBinding
import by.maxluxs.polyc.databinding.ItemMyAppointmentBinding
import by.maxluxs.polyc.domain.model.Doctor
import by.maxluxs.polyc.domain.model.initials
import model.Department

/**
 *
 * */
class DoctorItemHolder(
    private val binding: ItemDoctorBinding,
    private val callback: DoctorCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Doctor) {
        renderData(model)
        setListeners(model)
    }

    private fun renderData(model: Doctor) {
        binding.name.text = model.name
        binding.surname.text = model.surname
        binding.cabinet.text = model.cabinet
        binding.telephone.text = model.telephone
        binding.department.text = model.department?.specialization
        binding.icon.text = model.initials()
    }

    private fun setListeners(model: Doctor) {
        binding.item.setOnClickListener {
            callback.onClickDoctorItem(model)
        }
    }

}

class DepartmentItemHolder(
    private val binding: ItemDepartmentBinding,
    private val callback: DepartmentCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Department) {
        renderData(model)
        setListeners(model)
    }

    private fun renderData(model: Department) {
        binding.telephone.text = model.telephone
        binding.specialization.text = model.specialization
    }

    private fun setListeners(model: Department) {
        binding.item.setOnClickListener {
            callback.onClickDoctorItem(model)
        }
    }

}