package com.example.rahal.ui.busniessowner

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentSignUpBusinessOwnerBinding
import java.util.regex.Pattern

class SignUpBusinessOwnerFragment : Fragment() {
    lateinit var binding: FragmentSignUpBusinessOwnerBinding
    private lateinit var validEmailEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var verifyPasswordEditText: EditText
    private lateinit var validEmailErrorMessage: TextView
    private lateinit var phoneNumberErrorMessage: TextView
    private lateinit var passwordErrorMessage: TextView
    private lateinit var verifyPasswordErrorMessage: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBusinessOwnerBinding.inflate(inflater,container,false)
        initializeVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        validateEmail()
        validatePassword()
        validateVerifyPassword()

        binding.backArrowButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.logInBusinessOwnerFragment)
        }

        binding.logInTextVeiw.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.logInBusinessOwnerFragment)
        }
    }

    private fun initializeVariables(){
        validEmailEditText = binding.validEmailEditText
        validEmailErrorMessage = binding.errorMessageValidEmail

        phoneNumberEditText = binding.phoneNumberEditText
        phoneNumberErrorMessage = binding.errorMessagePhoneNumber

        passwordEditText = binding.passwordEditText
        passwordErrorMessage = binding.errorMessagePassword

        verifyPasswordEditText = binding.verifyPasswordEditText
        verifyPasswordErrorMessage = binding.errorMessagePasswordVerify
    }

    private fun showErrorMessage(editText: EditText, textView: TextView, errorMessage: String){
        editText.error = errorMessage
        textView.text = errorMessage
    }

    private fun validateEmail(){
        val errorMessage = "Enter a valid email"

        validEmailEditText.doAfterTextChanged {
            if (validEmailEditText.text.toString().isNotEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(validEmailEditText.text.toString()).matches()) {
                validEmailErrorMessage.text = ""
            }else {
                showErrorMessage(validEmailEditText,validEmailErrorMessage,errorMessage)
            }
        }
    }

    private fun validatePassword(){
        val errorMessage = "password should contain a-z , A-z , 0-9"
        val uppercase: Pattern = Pattern.compile("[A-Z]")
        val lowercase: Pattern = Pattern.compile("[a-z]")
        val digit: Pattern = Pattern.compile("[0-9]")

        passwordEditText.doAfterTextChanged {
            // if lowercase character is not present
            if(!lowercase.matcher(passwordEditText.text.toString()).find()){
                showErrorMessage(passwordEditText,passwordErrorMessage,errorMessage)
            }else{
                passwordErrorMessage.text = ""
            }

            // if uppercase character is not present
            if (!uppercase.matcher(passwordEditText.text.toString()).find()){
                showErrorMessage(passwordEditText,passwordErrorMessage,errorMessage)
            }else{
                passwordErrorMessage.text = ""
            }

            // if digit is not present
            if (!digit.matcher(passwordEditText.text.toString()).find()){
                showErrorMessage(passwordEditText,passwordErrorMessage,errorMessage)
            }else{
                passwordErrorMessage.text = ""
            }

            // if password length is less than 8
            if (passwordEditText.text.toString().length < 8){
                showErrorMessage(passwordEditText,passwordErrorMessage,errorMessage)
            }else{
                passwordErrorMessage.text = ""
            }
        }
    }

    private fun validateVerifyPassword(){
        val errorMessage = "Rematch password"
        verifyPasswordEditText.doAfterTextChanged {
            if (passwordEditText.text.toString() == verifyPasswordEditText.text.toString() ){
                verifyPasswordErrorMessage.text = ""
            }else {
                showErrorMessage(verifyPasswordEditText,verifyPasswordErrorMessage,errorMessage)
            }
        }
    }

}