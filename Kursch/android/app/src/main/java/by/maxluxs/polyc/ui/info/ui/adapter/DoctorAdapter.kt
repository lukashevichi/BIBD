package by.maxluxs.polyc.ui.info.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.polyc.databinding.ItemDepartmentBinding
import by.maxluxs.polyc.databinding.ItemDoctorBinding
import by.maxluxs.polyc.databinding.ItemMyAppointmentBinding
import by.maxluxs.polyc.domain.model.Doctor
import by.maxluxs.polyc.ui.info.domain.InfoModel
import model.Department

/**
 *
 * */
class DoctorAdapter :
    ListAdapter<Doctor, DoctorItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    DoctorCallback {

    var clickCallback: ((Doctor) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Doctor>() {

            override fun areContentsTheSame(
                oldItem: Doctor,
                newItem: Doctor
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorItemHolder {
        val binding =
            ItemDoctorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorItemHolder(binding, this)
    }

    override fun onBindViewHolder(holder: DoctorItemHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onClickDoctorItem(model: Doctor) {
        clickCallback?.invoke(model)
    }

}

class DepartmentAdapter :
    ListAdapter<Department, DepartmentItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    DepartmentCallback {

    var clickCallback: ((Department) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Department>() {

            override fun areContentsTheSame(
                oldItem: Department,
                newItem: Department
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Department, newItem: Department): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentItemHolder {
        val binding =
            ItemDepartmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DepartmentItemHolder(binding, this)
    }

    override fun onBindViewHolder(holder: DepartmentItemHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onClickDoctorItem(model: Department) {
        clickCallback?.invoke(model)
    }

}