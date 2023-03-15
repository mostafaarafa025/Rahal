package com.example.rahal.ui.busniessowner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentForgetPasswordBusinessOwnerBinding

class ForgetPasswordBusinessOwnerFragment : Fragment() {
    lateinit var binding: FragmentForgetPasswordBusinessOwnerBinding
    private lateinit var sendMailButton: Button
    private lateinit var backArrowButton: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForgetPasswordBusinessOwnerBinding.inflate(inflater,container,false)
        intilaizeVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backArrowButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.logInBusinessOwnerFragment)
        }

        sendMailButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.verificationCodeBusinessOwnerFragment)
        }


    }

    private fun intilaizeVariables(){
        backArrowButton = binding.backArrowButton
        sendMailButton = binding.sendMailButton
    }


}