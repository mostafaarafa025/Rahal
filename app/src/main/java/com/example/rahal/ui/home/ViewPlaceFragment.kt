package com.example.rahal.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.rahal.R
import com.example.rahal.data.Place
import com.example.rahal.databinding.FragmentViewPlaceBinding
import com.example.rahal.remove.SliderAdapter
import com.example.rahal.remove.SliderItem
import com.example.rahal.viewModels.ViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ViewPlaceFragment : Fragment() {
    private lateinit var binding:FragmentViewPlaceBinding
    private lateinit var options: ImageView
    private lateinit var title: TextView
    private lateinit var image: String
    private lateinit var ratingBar: RatingBar
    private lateinit var reviews: TextView
    private lateinit var description: TextView
    private lateinit var location: TextView

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewPlaceBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        intilaizeVariables()
        getData()

        options.setOnClickListener { showPopupMenu() }

    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(requireContext(), options)
        popupMenu.menuInflater.inflate(R.menu.review_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.review -> {
                    view?.let { Navigation.findNavController(it).navigate(R.id.action_viewPlaceFragment_to_reviewFragment) }
                    // Handle menu item 1 selection
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    private fun intilaizeVariables(){
        options = binding.optionButton
        title = binding.placeNameTextView
        ratingBar = binding.starIcon
        reviews = binding.numberOfReviewsTextView
        description = binding.descriptionBodyTextView
        location = binding.location

    }

    fun getData(){
        val data = arguments
        if (data != null){
            title.text = data.getString("title").toString()
            ratingBar.rating = data.getDouble("rate").toFloat()
            reviews.text = data.getString("reviews").toString()
            description.text = data.getString("description").toString()
            location.text = data.getString("location").toString()
            image = data.getString("image").toString()
            Glide.with(requireContext()).load(image).into(binding.imageView)
        }
    }

}