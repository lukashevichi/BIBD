package by.maxluxs.polyc.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.polyc.databinding.ItemMyAppointmentBinding
import by.maxluxs.polyc.domain.model.Appointment

/**
 *
 * */
class CurrencyItemHolder(
    private val binding: ItemMyAppointmentBinding,
    private val callback: AppointmentCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Appointment) {
        renderData(model)
        setListeners(model)
    }

    private fun renderData(model: Appointment) {
        binding.date.text = model.date
        binding.doctor.text = model.doctor?.name + " " + model.doctor?.surname
        binding.time.text = model.time
    }

    private fun setListeners(model: Appointment) {
        binding.item.setOnClickListener {
            callback.onClickAppointmentItem(model)
        }
    }

}