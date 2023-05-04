package com.example.rahal.ui.user

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentFollowSignUpUserBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class FollowSignUpUserFragment : Fragment(){
    lateinit var binding: FragmentFollowSignUpUserBinding
    private lateinit var phoneEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var birthDateEditText: EditText
    private lateinit var genderFieldEditText: AutoCompleteTextView
    private lateinit var phoneErrorMessage: TextView
    private lateinit var cityErrorMessage: TextView
    private lateinit var birthDateErrorMessage: TextView
    private lateinit var genderFieldErrorMessage: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFollowSignUpUserBinding.inflate(inflater,container,false)

        intilaizeVariable()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)// Calendar
           showDatePicker()
           customSpinner()
           validatePhoneNumber()
           validateCity()
           validateBirthDate()
           //validateGender()
        binding.backArrowButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.signUpUserFragment)
        }

        binding.logInTextVeiw.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.logInUserFragment)
        }


    }

    private fun intilaizeVariable(){
        phoneEditText = binding.phoneNumberEditText
        phoneErrorMessage = binding.errorMessagePhoneNumber

        cityEditText = binding.cityEditText
        cityErrorMessage = binding.errorMessageCity

        birthDateEditText = binding.dateOfBirthEditText
        birthDateErrorMessage = binding.errorMessageBirthDate

        genderFieldEditText = binding.spinnerAutoComplete
        genderFieldErrorMessage = binding.errorMessageGender
    }

    private fun showErrorMessage(editText: EditText, textView: TextView, errorMessage: String){
        editText.error = errorMessage
        textView.text = errorMessage
    }

    private fun showDatePicker(){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // to show DatePickerDialoge
        birthDateEditText.setOnClickListener {
            val datePickerDialog = DatePickerDialog(it.context, { _, myYear, myMonth, myDay ->
                // set to editText
                birthDateEditText.setText("$myDay/$myMonth/$myYear")
            },year,month,day)
            // show dialog
            datePickerDialog.show()
        }
    }

    private fun customSpinner(){
        val gender = resources.getStringArray(R.array.gender)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,gender)
        genderFieldEditText.setAdapter(arrayAdapter)
    }

    private fun validatePhoneNumber(){
        phoneEditText.doAfterTextChanged {
            val errorMessage = "Phone Number is required"
            if (phoneEditText.text.toString().isEmpty()){
                showErrorMessage(phoneEditText,phoneErrorMessage,errorMessage)
            }else {
                phoneErrorMessage.text = ""
            }
        }
    }

    private fun validateCity(){
        cityEditText.doAfterTextChanged {
            val errorMessage = "City is required"
            if (cityEditText.text.toString().isEmpty()){
                showErrorMessage(cityEditText,cityErrorMessage,errorMessage)
            }else {
                cityErrorMessage.text = ""
            }
        }
    }

    private fun validateBirthDate(){
        birthDateEditText.doAfterTextChanged {
            val errorMessage = "Birth Date is required"
            if (birthDateEditText.text.toString().isEmpty()){
                showErrorMessage(birthDateEditText,birthDateErrorMessage,errorMessage)
            }else {
                birthDateErrorMessage.text = ""
            }
        }
    }

//    private fun validateGender(){
//        genderFieldEditText.doAfterTextChanged {
//            val errorMessage = "Gender is required"
//            if (genderFieldEditText.text.toString().isEmpty()){
//                showErrorMessage(genderFieldEditText,genderFieldErrorMessage,errorMessage)
//            }else {
//                genderFieldErrorMessage.text = ""
//            }
//        }
//    }

}