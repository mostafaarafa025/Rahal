package com.example.rahal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.example.rahal.R
import com.example.rahal.databinding.FragmentHomePageBinding
import com.example.rahal.remove.Circle
import com.example.rahal.remove.CircleAdapter
import com.example.rahal.remove.RectangleAdapter
import com.example.rahal.remove.rectangle


class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var helpIcon:ImageView
    private lateinit var recommendedViewAll:TextView
    private lateinit var topRatedViewAll:TextView
    private val myAdapter by lazy { RectangleAdapter() }
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

        binding.recommendedRecyclerView.adapter=myAdapter
        binding.topRatedRecyclerView.adapter=myAdapter
        binding.favoriteRecyclerView.adapter=circleAdapter

        val rectangle1= rectangle(1,R.drawable.kfc,"kfc","Alexandria,Egypt",4)
        val rectangle2=rectangle(2,R.drawable.papajohnes,"papajhones","Alexandria,Egypt",5)
        val rectangle3=rectangle(3,R.drawable.bruxies,"bruxis","cairo,Egypt",2)
        val rectangle4=rectangle(4,R.drawable.macdonalds,"macdonalds","tanta,Egypt",4)
        val rectangle5=rectangle(5,R.drawable.cairo,"cairo","portsaid,Egypt",4)

        myAdapter.setData(listOf(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,
            rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,
            rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,
            rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,
        ))

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
            Navigation.findNavController(view).navigate(R.id.action_homePageFragment_to_viewAllActivitesFragment)
        }

        topRatedViewAll.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homePageFragment_to_viewAllActivitesFragment)
        }
    }
}
