package by.maxluxs.polyc.ui.appointments.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.polyc.databinding.ItemAppointmentItemViewBinding
import by.maxluxs.polyc.domain.model.Appointment
import by.maxluxs.polyc.domain.model.initials
import by.maxluxs.polyc.ui.appointments.layoutInflater

class AppointmentAdapter(val onClick: (Appointment) -> Unit) :
    RecyclerView.Adapter<AppointmentAdapter.Example3EventsViewHolder>() {
    val events = mutableListOf<Appointment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Example3EventsViewHolder {
        return Example3EventsViewHolder(
            ItemAppointmentItemViewBinding.inflate(parent.context.layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: Example3EventsViewHolder, position: Int) {
        viewHolder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    inner class Example3EventsViewHolder(private val binding: ItemAppointmentItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onClick(events[bindingAdapterPosition])
            }
        }

        fun bind(appointment: Appointment) {
            binding.itemEventText.text = "${appointment.doctor?.initials()} ${appointment.date} ${appointment.time}"
        }
    }

}