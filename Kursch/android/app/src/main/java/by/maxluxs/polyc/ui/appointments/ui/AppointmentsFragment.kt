package by.maxluxs.polyc.ui.appointments.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.polyc.R
import by.maxluxs.polyc.databinding.FragmentAppointmentsBinding
import by.maxluxs.polyc.databinding.ItemCalendarDayBinding
import by.maxluxs.polyc.databinding.ItemCalendarHeaderBinding
import by.maxluxs.polyc.ui.appointment.AppointmentFragment
import by.maxluxs.polyc.ui.appointments.*
import by.maxluxs.polyc.ui.appointments.presentation.AppointmentsViewModel
import by.maxluxs.polyc.ui.appointments.setTextColorRes
import by.maxluxs.polyc.ui.home.adapter.AppointmentAdapter
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class AppointmentsFragment : Fragment(R.layout.fragment_appointments) {

    private val appointmentsViewModel: AppointmentsViewModel by viewModels()

    private fun inputDialog() {
        AppointmentFragment()
            .apply {
                selectedDate?.let { date = it.toString() }
                patient = appointmentsViewModel.patient
                onCreatedCallback = { appointmentsViewModel.getAppointments() }
            }
            .show(childFragmentManager, AppointmentFragment.tag)
    }

    private var _binding: FragmentAppointmentsBinding? = null
    private val binding get() = _binding!!

    private val appointments get() = appointmentsViewModel.appointments.value ?: emptyMap()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAppointmentsBinding.bind(view)
        binding.exThreeRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = appointmentAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
        binding.refresh.setOnRefreshListener {
            appointmentsViewModel.getAppointments()
        }
        appointmentsViewModel.appointments.observe(viewLifecycleOwner) {
            selectedDate?.let { updateAdapterForDate(it) }
            binding.refresh.isRefreshing = false
        }

        val daysOfWeek = daysOfWeekFromLocale()
        val currentMonth = YearMonth.now()
        binding.exThreeCalendar.apply {
            setup(currentMonth.minusMonths(10), currentMonth.plusMonths(10), daysOfWeek.first())
            scrollToMonth(currentMonth)
        }

        if (savedInstanceState == null) {
            binding.exThreeCalendar.post {
                selectDate(today)
            }
        }

        class DayViewContainer(view: View) : ViewContainer(view) {
            lateinit var day: CalendarDay // Will be set when this container is bound.
            val binding = ItemCalendarDayBinding.bind(view)

            init {
                view.setOnClickListener {
                    if (day.owner == DayOwner.THIS_MONTH) {
                        selectDate(day.date)
                    }
                }
            }
        }
        binding.exThreeCalendar.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                val textView = container.binding.exThreeDayText
                val dotView = container.binding.exThreeDotView

                textView.text = day.date.dayOfMonth.toString()

                if (day.owner == DayOwner.THIS_MONTH) {
                    textView.makeVisible()
                    when (day.date) {
                        today -> {
                            textView.setTextColorRes(R.color.example_3_white)
                            textView.setBackgroundResource(R.drawable.today_bg)
                            dotView.makeInVisible()
                        }
                        selectedDate -> {
                            textView.setTextColorRes(R.color.example_3_blue)
                            textView.setBackgroundResource(R.drawable.selected_bg)
                            dotView.makeInVisible()
                        }
                        else -> {
                            textView.setTextColorRes(R.color.example_3_black)
                            textView.background = null
                            dotView.isVisible = appointments[day.date].orEmpty().isNotEmpty()
                        }
                    }
                } else {
                    textView.makeInVisible()
                    dotView.makeInVisible()
                }
            }
        }

        binding.exThreeCalendar.monthScrollListener = {
//            homeActivityToolbar.title = if (it.year == today.year) {
//                titleSameYearFormatter.format(it.yearMonth)
//            } else {
//                titleFormatter.format(it.yearMonth)
//            }

            // Select the first day of the month when
            // we scroll to a new month.
            selectDate(it.yearMonth.atDay(1))
        }

        class MonthViewContainer(view: View) : ViewContainer(view) {
            val legendLayout = ItemCalendarHeaderBinding.bind(view).legendLayout.root
        }
        binding.exThreeCalendar.monthHeaderBinder =
            object : MonthHeaderFooterBinder<MonthViewContainer> {
                override fun create(view: View) = MonthViewContainer(view)
                override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                    // Setup each header day text if we have not done that already.
                    if (container.legendLayout.tag == null) {
                        container.legendLayout.tag = month.yearMonth
                        container.legendLayout.children.map { it as TextView }
                            .forEachIndexed { index, tv ->
                                tv.text = daysOfWeek[index].name.first().toString()
                                tv.setTextColorRes(R.color.example_3_black)
                            }
                    }
                }
            }

        binding.exThreeAddButton.setOnClickListener {
            inputDialog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private val appointmentAdapter = AppointmentAdapter()

    private var selectedDate: LocalDate? = null
    private val today = LocalDate.now()

    private val titleSameYearFormatter = DateTimeFormatter.ofPattern("MMMM")
    private val titleFormatter = DateTimeFormatter.ofPattern("MMM yyyy")
    private val selectionFormatter = DateTimeFormatter.ofPattern("d MMM yyyy")

    private fun selectDate(date: LocalDate) {
        if (selectedDate != date) {
            val oldDate = selectedDate
            selectedDate = date
            oldDate?.let { binding.exThreeCalendar.notifyDateChanged(it) }
            binding.exThreeCalendar.notifyDateChanged(date)
            updateAdapterForDate(date)
        }
    }

    private fun updateAdapterForDate(date: LocalDate) {
        Log.e("!!!", appointments.toString())
        appointmentAdapter.apply {
            clear()
            submitList(this@AppointmentsFragment.appointments[date].orEmpty())
        }
        binding.exThreeSelectedDateText.text = selectionFormatter.format(date)
    }

}