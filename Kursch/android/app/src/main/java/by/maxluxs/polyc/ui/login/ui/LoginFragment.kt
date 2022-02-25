package by.maxluxs.polyc.ui.login.ui

import androidx.lifecycle.Observer
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.maxluxs.polyc.databinding.FragmentLoginBinding

import by.maxluxs.polyc.R
import by.maxluxs.polyc.data.local.preferences.AuthPreferences
import by.maxluxs.polyc.ui.login.presentation.LoggedInUserView
import by.maxluxs.polyc.ui.login.presentation.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        loginViewModel.root.observe(viewLifecycleOwner) {
            binding.polyclinicName.text = it.polyclinicName
        }

        loginViewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                binding.actionButton.isEnabled = loginFormState.isDataValid
                loginFormState.usernameError?.let {
                    binding.email.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    binding.password.error = getString(it)
                }
            })

        loginViewModel.loginResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer
                binding.loading.visibility = View.GONE
                loginResult.error?.let {
                    showLoginFailed(it)
                }
                loginResult.success?.let {
                    updateUiWithUser(it)
                }
            })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, st: Int, c: Int, a: Int) = Unit
            override fun onTextChanged(s: CharSequence, st: Int, b: Int, c: Int) = Unit
            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                    binding.email.text.toString(),
                    binding.password.text.toString()
                )
            }
        }
        binding.email.addTextChangedListener(afterTextChangedListener)
        binding.password.addTextChangedListener(afterTextChangedListener)
        binding.password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(
                    email = binding.email.text.toString(),
                    password = binding.password.text.toString()
                )
            }
            false
        }

        binding.actionButton.setOnClickListener { listenLogin() }

        binding.changeButton.setOnClickListener {
            if (binding.actionButton.text == getString(R.string.action_sign_up)) {
                binding.actionButton.text = getString(R.string.action_sign_in)
                binding.changeButton.text = getString(R.string.action_sign_up)
                binding.actionButton.setOnClickListener { listenLogin() }
                binding.name.isVisible = false
                binding.surname.isVisible = false
            } else {
                binding.actionButton.text = getString(R.string.action_sign_up)
                binding.changeButton.text = getString(R.string.action_sign_in)
                binding.actionButton.setOnClickListener { listenReg() }
                binding.name.isVisible = true
                binding.surname.isVisible = true
            }
        }

    }

    private fun listenLogin() {
        binding.loading.visibility = View.VISIBLE
        loginViewModel.login(
            email = binding.email.text.toString(),
            password = binding.password.text.toString()
        )
    }

    private fun listenReg() {
        binding.loading.visibility = View.VISIBLE
        loginViewModel.reg(
            email = binding.email.text.toString(),
            name = binding.name.text.toString(),
            surname = binding.surname.text.toString(),
            password = binding.password.text.toString()
        )
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome) + model.displayName
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
        findNavController().navigate(LoginFragmentDirections.toContentNavigation())
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}