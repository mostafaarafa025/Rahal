package com.example.rahal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rahal.databinding.FragmentPlansBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlansFragment : Fragment() {
    private lateinit var binding: FragmentPlansBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlansBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.tabLayoutPlans
        val viewPager = binding.viewPagerPlans
        val adapter = ViewPagerAdapter(childFragmentManager,lifecycle)

        viewPager.adapter = adapter


        TabLayoutMediator(tabLayout,viewPager){tab,position->
            when(position){
                0->{ tab.text = "Your Plans" }
                1->{ tab.text = "Recomended plans"}
            }
        }.attach()


    }



}