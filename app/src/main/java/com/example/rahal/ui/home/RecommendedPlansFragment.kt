package com.example.rahal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahal.R
import com.example.rahal.databinding.FragmentRecommendedPlansBinding
import com.example.rahal.remove.Circle
import com.example.rahal.remove.PlansAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendedPlansFragment : Fragment() {
    private lateinit var binding: FragmentRecommendedPlansBinding
    private val myAdapter by lazy { PlansAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecommendedPlansBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recommendedPlansRecyclerView.adapter = myAdapter

        val item= Circle(1,R.drawable.museums,"Musuems")
        myAdapter.setCircleData(listOf(item,item,item,item,item,item))
    }
}