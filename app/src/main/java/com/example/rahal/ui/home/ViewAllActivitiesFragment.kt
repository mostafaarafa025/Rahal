package com.example.rahal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentViewAllActivitesBinding
import com.example.rahal.remove.ViewAllAdapter
import com.example.rahal.remove.rectangle


class ViewAllActivitiesFragment : Fragment() {
    private lateinit var binding:FragmentViewAllActivitesBinding
    private val myAdapter by lazy { ViewAllAdapter() }
    private lateinit var backButton:ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewAllActivitesBinding.inflate(inflater,container,false)

        intilaizeVariable()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_viewAllActivitesFragment_to_homePageFragment)
        }

        val rectangle= rectangle(5, R.drawable.cairo,"cairo","Cairo,Egypt",4)
        myAdapter.setData(listOf(rectangle,rectangle,rectangle,rectangle,rectangle,rectangle,rectangle,
            rectangle,rectangle,rectangle,rectangle,rectangle,rectangle,rectangle,rectangle,rectangle,))
    }

    private fun intilaizeVariable(){
        backButton = binding.backArrowButton

        binding.viewAllRecyclerView.adapter = myAdapter
    }

}