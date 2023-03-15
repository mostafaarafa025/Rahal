package com.example.rahal.ui.busniessowner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentChangePasswordBusinessOwnerBinding
import java.util.regex.Pattern

class ChangePasswordBusinessOwnerFragment : Fragment() {
    lateinit var binding: FragmentChangePasswordBusinessOwnerBinding
    private lateinit var enterPasswordEditText: EditText
    private lateinit var renterPasswordEditText: EditText
    private lateinit var enterPasswordErrorMessage: TextView
    private lateinit var renterPasswordErrorMessage: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChangePasswordBusinessOwnerBinding.inflate(inflater,container,false)
        initializeVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        validatePassword()
        validateRenterPassword()

        binding.backArrowButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.verificationCodeBusinessOwnerFragment)
        }

        binding.submitButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.passwordChangedOrFailedBusinessOwnerFragment)
        }
    }

    private fun initializeVariables(){
        enterPasswordEditText = binding.enterPasswordEditText
        enterPasswordErrorMessage = binding.errorMessagePassword

        renterPasswordEditText = binding.renterPasswordEditText
        renterPasswordErrorMessage = binding.errorMessageRenterPassword
    }

    private fun showErrorMessage(editText: EditText, textView: TextView, errorMessage: String){
        editText.error = errorMessage
        textView.text = errorMessage
    }

    private fun validatePassword(){
        val errorMessage = "password should contain a-z , A-z , 0-9"
        val uppercase: Pattern = Pattern.compile("[A-Z]")
        val lowercase: Pattern = Pattern.compile("[a-z]")
        val digit: Pattern = Pattern.compile("[0-9]")

        enterPasswordEditText.doAfterTextChanged {
            // if lowercase character is not present
            if(!lowercase.matcher(enterPasswordEditText.text.toString()).find()){
                showErrorMessage(enterPasswordEditText,enterPasswordErrorMessage,errorMessage)
            }else{
                enterPasswordErrorMessage.text = ""
            }

            // if uppercase character is not present
            if (!uppercase.matcher(enterPasswordEditText.text.toString()).find()){
                showErrorMessage(enterPasswordEditText,enterPasswordErrorMessage,errorMessage)
            }else{
                enterPasswordErrorMessage.text = ""
            }

            // if digit is not present
            if (!digit.matcher(enterPasswordEditText.text.toString()).find()){
                showErrorMessage(enterPasswordEditText,enterPasswordErrorMessage,errorMessage)
            }else{
                enterPasswordErrorMessage.text = ""
            }

            // if password length is less than 8
            if (enterPasswordEditText.text.toString().length < 8){
                showErrorMessage(enterPasswordEditText,enterPasswordErrorMessage,errorMessage)
            }else{
                enterPasswordErrorMessage.text = ""
            }
        }
    }

    private fun validateRenterPassword(){
        val errorMessage = "Rematch password"
        renterPasswordEditText.doAfterTextChanged {
            if (enterPasswordEditText.text.toString() == renterPasswordEditText.text.toString() ){
                renterPasswordErrorMessage.text = ""
            }else {
                showErrorMessage(renterPasswordEditText,renterPasswordErrorMessage,errorMessage)
            }
        }
    }


}