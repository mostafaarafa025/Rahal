package com.example.rahal.ui.home

import android.os.Bundle
import android.view.*
import android.view.View.inflate
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.ActivityMainBusniessOwnerBinding.inflate
import com.example.rahal.databinding.ActivityMainUserBinding.inflate
import com.example.rahal.databinding.FragmentViewPlaceBinding
import com.example.rahal.remove.SliderAdapter
import com.example.rahal.remove.SliderItem
import java.util.zip.Inflater


class ViewPlaceFragment : Fragment() {
    private lateinit var binding:FragmentViewPlaceBinding
    private lateinit var options: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewPlaceBinding.inflate(inflater,container,false)
        options = binding.optionButton
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        options.setOnClickListener { showPopupMenu() }

        sliderImage()

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


    private fun sliderImage(){
        val sliderItems = listOf(
            SliderItem(R.drawable.museums),
            SliderItem(R.drawable.papajohnes),
            SliderItem(R.drawable.hollybelly),
            SliderItem(R.drawable.macdonalds)
        )

        val sliderAdapter = SliderAdapter(sliderItems, binding.placeImageViewPager)
        binding.placeImageViewPager.adapter = sliderAdapter
        sliderAdapter.startAutoSlider()
    }

}