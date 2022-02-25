package by.maxluxs.polyc.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.polyc.R
import by.maxluxs.polyc.databinding.FragmentHomeBinding
import by.maxluxs.polyc.ui.home.adapter.AppointmentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val adapter get() = binding.myAppointments.adapter as AppointmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        homeViewModel.models.observe(viewLifecycleOwner) {
            adapter.submitList(it.appointments)
            binding.noAppointments.isVisible = it.appointments.isEmpty()
        }
        binding.myAppointments.apply {
            adapter = AppointmentAdapter()
            layoutManager = LinearLayoutManager(requireContext())
        }
        homeViewModel.root.observe(viewLifecycleOwner) {
            binding.polyclinicName.text = it.polyclinicName
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}