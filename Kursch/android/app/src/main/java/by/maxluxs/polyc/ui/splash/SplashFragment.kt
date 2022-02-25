package by.maxluxs.polyc.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.maxluxs.polyc.R
import by.maxluxs.polyc.data.local.preferences.AuthPreferences
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val authPrefs: AuthPreferences
        get() = AuthPreferences(requireContext())

    private val navController: NavController
        get() = findNavController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        checkAuthPrefs()
    }

    private fun checkAuthPrefs() {
        if (authPrefs.checkAuth()) {
            navController.navigate(R.id.content_navigation)
        } else {
            navController.navigate(R.id.loginFragment)
        }
    }

}