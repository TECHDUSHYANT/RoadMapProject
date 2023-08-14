package com.example.roadmapproject.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.roadmapproject.R
import com.example.roadmapproject.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(){

    private  var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the submit button as disabled
        binding.submitButton.isEnabled = false

        // Set text change listeners for email and password fields
        binding.emailEditText.addTextChangedListener { checkFieldsValidity() }
        binding.passwordEditText.addTextChangedListener { checkFieldsValidity() }

        binding.submitButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_movieFragment)
        }
    }

    private fun checkFieldsValidity() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length in 8..15

        // Enable or disable the submit button based on field validity
        binding.submitButton.isEnabled = isEmailValid && isPasswordValid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
