package by.maxluxs.polyc.ui.appointment

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.polyc.data.local.model.initials
import by.maxluxs.polyc.databinding.DialogDoctorsBinding
import by.maxluxs.polyc.databinding.DialogProfileBinding
import by.maxluxs.polyc.databinding.FragmentAppointmentBinding
import by.maxluxs.polyc.domain.model.Patient
import by.maxluxs.polyc.ui.info.ui.adapter.DoctorAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AppointmentFragment : BottomSheetDialogFragment() {

    companion object {
        val tag: String = AppointmentFragment::class.java.name
    }

    private val viewModel: AppointmentViewModel by viewModels()

    var date: String? = null
    var patient: Patient? = null

    var onCreatedCallback: ((isCreated: Boolean) -> Unit)? = null

    private var _binding: FragmentAppointmentBinding? = null
    private val binding: FragmentAppointmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppointmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        date?.let { viewModel.setDate(it) }
        patient?.let { viewModel.setPatient(it) }
        viewModel.run {
            createdEvent.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), "Appointment created!", Toast.LENGTH_LONG).show()
                onCreatedCallback?.invoke(true)
                dismiss()
            }
            selectedDoctor.observe(viewLifecycleOwner) {
                binding.doctor.text = it.name + "  " + it.surname
            }
            selectedPatient.observe(viewLifecycleOwner) {
                binding.patient.text = it.name + "  " + it.surname
            }
            selectedDate.observe(viewLifecycleOwner) { binding.date.text = it }
            selectedTime.observe(viewLifecycleOwner) { binding.time.text = it }
            errorEvent.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
        binding.run {
            addButton.setOnClickListener { viewModel.addAppointment() }
            time.setOnClickListener { openTimeDialog() }
            doctor.setOnClickListener { showDoctors() }
        }
    }

    private fun openTimeDialog() {
        TimePickerDialog(
            requireContext(),
            { view, hourOfDay, minute ->
                if (hourOfDay in 9..20) {
                    viewModel.setTime("$hourOfDay:$minute:00")
                    Toast.makeText(
                        requireContext(),
                        "Вы выбрали время $hourOfDay:$minute",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Вы выбрали время $hourOfDay:$minute. В это время поликлиника не работает. Выберите другое время.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }, 19, 20, true
        ).run {
            show()
        }
    }

    private fun showDoctors() {
        val data = viewModel.models.value?.doctors
        val binding = DialogDoctorsBinding.inflate(layoutInflater)
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
            .apply {
                val doctorAdapter = DoctorAdapter().apply {
                    clickCallback = {
                        viewModel.setDoctor(it)
                        dismiss()
                    }

                }
                binding.doctors.apply {
                    adapter = doctorAdapter
                    layoutManager = LinearLayoutManager(requireContext())
                }
                doctorAdapter.submitList(data)
                binding.close.setOnClickListener { dismiss() }
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}