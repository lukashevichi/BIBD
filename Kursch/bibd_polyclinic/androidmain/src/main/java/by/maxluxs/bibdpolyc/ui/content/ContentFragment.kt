package by.maxluxs.polyc.ui.content

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.maxluxs.polyc.R
import by.maxluxs.polyc.databinding.ContentFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContentFragment : Fragment(R.layout.content_fragment) {

    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var viewModel: ContentViewModel

    private lateinit var binding: ContentFragmentBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContentViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ContentFragmentBinding.bind(view)
        setBottomView()
    }

    private fun setBottomView() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(
            requireActivity() as AppCompatActivity,
            navController,
            appBarConfiguration
        )
        navView.setupWithNavController(navController)
    }

}