package com.example.rahal.ui.busniessowner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahal.R
import com.example.rahal.databinding.FragmentChangePasswordBusinessOwnerBinding

class ChangePasswordBusinessOwnerFragment : Fragment() {
    lateinit var binding: FragmentChangePasswordBusinessOwnerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChangePasswordBusinessOwnerBinding.inflate(inflater,container,false)
        return binding.root
    }

}