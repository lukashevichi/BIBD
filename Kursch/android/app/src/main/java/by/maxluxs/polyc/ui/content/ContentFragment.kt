package by.maxluxs.polyc.ui.content

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import by.maxluxs.polyc.R
import by.maxluxs.polyc.data.local.model.initials
import by.maxluxs.polyc.data.local.preferences.AuthPreferences
import by.maxluxs.polyc.databinding.DialogProfileBinding
import by.maxluxs.polyc.databinding.FragmentContentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentFragment : Fragment(R.layout.fragment_content) {

    companion object {
        private val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_destination, R.id.info_destination, R.id.appointments_destination)
        )
    }

    private val prefs get() = AuthPreferences(requireContext())

    private val navHostFragment: NavHostFragment
        get() =
            childFragmentManager.findFragmentById(R.id.content_container) as NavHostFragment

    private val navController get() = navHostFragment.navController

    private val viewModel: ContentViewModel by viewModels()

    private lateinit var binding: FragmentContentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContentBinding.bind(view)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setBottomView()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.profile_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile -> showProfile()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showProfile(): Boolean {
        val data = prefs.getAuth()
        val binding = DialogProfileBinding.inflate(layoutInflater)
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
            .apply {
                binding.logOutButton.setOnClickListener {
                    logOut()
                    hide()
                }
                binding.closeButton.setOnClickListener { hide() }
                binding.email.text = data?.email
                binding.name.text = data?.name
                binding.surname.text = data?.surname
                binding.icon.text = data?.initials()
            }
            .show()
            .run { true }
    }

    private fun logOut() {
        prefs.removeAuth()
        findNavController().navigate(R.id.splashFragment)
    }

    private fun setBottomView() {
        val navView: BottomNavigationView = binding.navView
        setupActionBarWithNavController(
            requireActivity() as AppCompatActivity,
            navController,
            appBarConfiguration
        )
        setupWithNavController(navView, navController)
    }

}