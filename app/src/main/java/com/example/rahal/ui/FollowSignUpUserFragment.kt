package com.example.rahal.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentFollowSignUpUserBinding
import kotlinx.android.synthetic.main.fragment_follow_sign_up_user.*
import java.util.Calendar


class FollowSignUpUserFragment : Fragment(){
    lateinit var binding: FragmentFollowSignUpUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowSignUpUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)// Calendar
           showDatePicker()
           customSpinner()
        binding.backArrowButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.signUpUserFragment)
        }

        binding.logInTextVeiw.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.logInUserFragment)
        }


    }

    fun showDatePicker(){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // to show DatePickerDialoge
        binding.dateOfBirthEditText.setOnClickListener {
            val datePickerDialog = DatePickerDialog(it.context,DatePickerDialog.OnDateSetListener{view,myYear,myMonth,myDay ->

                // set to editText
                binding.dateOfBirthEditText.setText(""+myDay +"/"+ myMonth +"/" +myYear)

            },year,month,day)

            // show dialog
            datePickerDialog.show()
        }
    }

    fun customSpinner(){
        val gender = resources.getStringArray(R.array.gender)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,gender)
        binding.spinnerAutoComplete.setAdapter(arrayAdapter)
    }

}