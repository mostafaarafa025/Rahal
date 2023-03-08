package com.example.rahal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentLandingPageBinding


class LandingPageFragment : Fragment() {
    lateinit var binding: FragmentLandingPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.logInUserFragment)
        }

        binding.bussinessOwnerButton.setOnClickListener { 
            Navigation.findNavController(view).navigate(R.id.logInBusinessOwnerFragment)
        }
    }


}