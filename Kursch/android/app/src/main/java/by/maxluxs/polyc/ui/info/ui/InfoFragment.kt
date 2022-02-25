package by.maxluxs.polyc.ui.info.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.maxluxs.polyc.R
import by.maxluxs.polyc.databinding.FragmentInfoBinding
import by.maxluxs.polyc.ui.info.InfoViewModel
import by.maxluxs.polyc.ui.info.ui.adapter.DepartmentAdapter
import by.maxluxs.polyc.ui.info.ui.adapter.DepartmentItemHolder
import by.maxluxs.polyc.ui.info.ui.adapter.DoctorAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val dashboardViewModel: InfoViewModel by viewModels()
    private var _binding: FragmentInfoBinding? = null

    private val binding get() = _binding!!

    private val doctorAdapter
        get() = binding.doctors.adapter as DoctorAdapter

    private val departmentAdapter
        get() = binding.department.adapter as DepartmentAdapter

    companion object {
        private const val COLLAPSE_ICON = R.drawable.ic_baseline_arrow_drop_down_24
        private const val EXPAND_ICON = R.drawable.ic_baseline_arrow_drop_up_24
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViews()
        initDoctorsViews()
        initDepartmentsViews()
        initObservers()
    }

    private fun initRecyclerViews() {
        binding.doctors.apply {
            adapter = DoctorAdapter()
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        binding.department.apply {
            adapter = DepartmentAdapter()
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun initObservers() {
        dashboardViewModel.models.observe(viewLifecycleOwner) {
            doctorAdapter.submitList(it.doctors)
            departmentAdapter.submitList(it.departments)
        }
    }

    private fun initDoctorsViews() {
        binding.doctorsTitle.setOnClickListener {
            dashboardViewModel.collapsedDoctorState.postValue(binding.doctors.isVisible.not())
        }
        dashboardViewModel.collapsedDoctorState.observe(viewLifecycleOwner) {
            binding.doctors.isVisible = it
            if (it) {
                binding.doctorsTitleIcon.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), EXPAND_ICON)
                )
            } else {
                binding.doctorsTitleIcon.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), COLLAPSE_ICON)
                )
            }
        }
    }

    private fun initDepartmentsViews() {
        binding.departmentTitle.setOnClickListener {
            dashboardViewModel.collapsedDepartmentState.postValue(binding.department.isVisible.not())
        }
        dashboardViewModel.collapsedDepartmentState.observe(viewLifecycleOwner) {
            binding.department.isVisible = it
            if (it) {
                binding.departmentTitleIcon.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), EXPAND_ICON)
                )
            } else {
                binding.departmentTitleIcon.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), COLLAPSE_ICON)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}