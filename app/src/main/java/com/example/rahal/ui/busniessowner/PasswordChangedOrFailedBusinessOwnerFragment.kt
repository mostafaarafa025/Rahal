package com.example.rahal.ui.busniessowner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahal.R
import com.example.rahal.databinding.FragmentPasswordChangedOrFailedBusinessOwnerBinding

class PasswordChangedOrFailedBusinessOwnerFragment : Fragment() {
    lateinit var binding: FragmentPasswordChangedOrFailedBusinessOwnerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPasswordChangedOrFailedBusinessOwnerBinding.inflate(inflater,container,false)
        return binding.root
    }

}