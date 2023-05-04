package com.example.rahal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.rahal.R
import com.example.rahal.adapters.RecommendedTopRatedAdapter
import com.example.rahal.databinding.FragmentHomePageBinding
import com.example.rahal.remove.Circle
import com.example.rahal.remove.CircleAdapter
import com.example.rahal.viewModels.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var helpIcon:ImageView
    private lateinit var recommendedViewAll:TextView
    private lateinit var topRatedViewAll:TextView
    private val viewModel: ViewModel by viewModels()
    private lateinit var recommendedAdapter : RecommendedTopRatedAdapter
    private lateinit var topRatedAdapter: RecommendedTopRatedAdapter
    private val circleAdapter by lazy { CircleAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recommendedViewAll = binding.recommendedViewAll
        topRatedViewAll = binding.topRatedViewAll
        binding.favoriteRecyclerView.adapter=circleAdapter

        getRecommended()
        getTopRated()
        onPlaceRecommendedClick()
        onPlaceTopRatedClick()


        val circle1= Circle(1,R.drawable.museums,"musuems")
        val circle2=Circle(1,R.drawable.museums,"shopping")
        val circle3=Circle(1,R.drawable.museums,"sports")
        val circle4=Circle(1,R.drawable.museums,"culture")
        val circle5=Circle(1,R.drawable.nile,"nile")

        circleAdapter.setCircleData(listOf(
            circle1,circle2,circle3,circle4,circle5,
            circle1,circle2,circle3,circle4,circle5,
            circle1,circle2,circle3,circle4,circle5,
            circle1,circle2,circle3,circle4,circle5,
            circle1,circle2,circle3,circle4,circle5))

        helpIcon = binding.helpIcon
        helpIcon.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homePageFragment_to_FAQFragment)
        }

        recommendedViewAll.setOnClickListener {
            onViewAllRecommendedClick()
        }

        topRatedViewAll.setOnClickListener {
            onViewAllTopRatedClick()
        }
    }

    private fun setupRecommendedRecyclerView(){
        recommendedAdapter = RecommendedTopRatedAdapter()
        binding.recommendedRecyclerView.apply {
            adapter = recommendedAdapter
        }
    }

    private fun setupTopRatedRecyclerView(){
        topRatedAdapter = RecommendedTopRatedAdapter()
        binding.topRatedRecyclerView.apply {
            adapter = topRatedAdapter
        }
    }

    private fun getTopRated(){
        setupTopRatedRecyclerView()
        viewModel.getTopRated()
        viewModel.getTopRatedLiveData.observe(viewLifecycleOwner, Observer {
            topRatedAdapter.differ.submitList(it)
        })
    }

    private fun getRecommended(){
        setupRecommendedRecyclerView()
        viewModel.getRecommended()
        viewModel.getRecommendedLiveData.observe(viewLifecycleOwner, Observer {
            recommendedAdapter.differ.submitList(it)
        })
    }

    private fun onViewAllRecommendedClick(){
        val fragment = ViewAllActivitiesFragment()
        val bundle = Bundle()
        bundle.putString("title",binding.recommendedTextView.text.toString())
        fragment.arguments = bundle
        findNavController().navigate(R.id.action_homePageFragment_to_viewAllActivitesFragment,bundle)
    }

    private fun onViewAllTopRatedClick(){
        val fragment = ViewAllActivitiesFragment()
        val bundle = Bundle()
        bundle.putString("title",binding.topRatedTextView.text.toString())
        fragment.arguments = bundle
        findNavController().navigate(R.id.action_homePageFragment_to_viewAllActivitesFragment,bundle)
    }

    private fun onPlaceRecommendedClick(){
        recommendedAdapter.onPlaceItemClick = { data ->
            val fragment = ViewPlaceFragment()
            val bundle = Bundle()
            bundle.putString("image",data.image)
            bundle.putDouble("rate",data.rating)
            bundle.putString("title",data.name)
            bundle.putString("reviews",data.num_reviews.toString())
            bundle.putString("description",data.description)
            bundle.putString("location",data.location.address)
            fragment.arguments = bundle
            findNavController().navigate(R.id.action_homePageFragment_to_viewPlaceFragment,bundle)
        }
    }

    private fun onPlaceTopRatedClick(){
        topRatedAdapter.onPlaceItemClick = { data ->
            val fragment = ViewPlaceFragment()
            val bundle = Bundle()
            bundle.putString("image",data.image)
            bundle.putDouble("rate",data.rating)
            bundle.putString("title",data.name)
            bundle.putString("reviews",data.num_reviews.toString())
            bundle.putString("description",data.description)
            bundle.putString("location",data.location.address)
            fragment.arguments = bundle
            findNavController().navigate(R.id.action_homePageFragment_to_viewPlaceFragment,bundle)
        }
    }

}
