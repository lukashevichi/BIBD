package by.maxluxs.polyc.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.polyc.databinding.ItemMyAppointmentBinding
import by.maxluxs.polyc.domain.model.Appointment

/**
 *
 * */
class AppointmentAdapter :
    ListAdapter<Appointment, CurrencyItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    AppointmentCallback {

    var clickCallback: ((Appointment) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Appointment>() {

            override fun areContentsTheSame(
                oldItem: Appointment,
                newItem: Appointment
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemHolder {
        val binding =
            ItemMyAppointmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyItemHolder(binding, this)
    }

    override fun onBindViewHolder(holder: CurrencyItemHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onClickAppointmentItem(model: Appointment) {
        clickCallback?.invoke(model)
    }

    fun clear() = submitList(emptyList())

}