package com.example.rahal.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.hilt.android.AndroidEntryPoint


class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) :FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0->{ YourPlansFragment() }
            1->{ RecommendedPlansFragment() }
            else ->{ Fragment()}

        }
    }
}