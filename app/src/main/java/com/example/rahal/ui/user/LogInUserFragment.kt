package com.example.rahal.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentLogInUserBinding


class LogInUserFragment : Fragment() {
    lateinit var binding: FragmentLogInUserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLogInUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrowButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.landingPageFragment)
        }

        binding.registerNowTextVeiw.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.signUpUserFragment)
        }

        binding.forgetPasswordTextView.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.forgetPasswordUserFragment)
        }
    }

}