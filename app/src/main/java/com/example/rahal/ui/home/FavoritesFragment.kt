package com.example.rahal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahal.R
import com.example.rahal.databinding.FragmentFavoritesBinding
import com.example.rahal.remove.FavouritesAdapter
import com.example.rahal.remove.RectangleAdapter
import com.example.rahal.remove.rectangle

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val myAdapter by lazy { FavouritesAdapter()}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favoritesRecylerView.adapter=myAdapter
        val rectangle1= rectangle(1, R.drawable.kfc,"kfc","Alexandria,Egypt",4)
        val rectangle2=rectangle(2, R.drawable.papajohnes,"papajhones","Alexandria,Egypt",5)
        val rectangle3=rectangle(3, R.drawable.bruxies,"bruxis","cairo,Egypt",2)
        val rectangle4=rectangle(4, R.drawable.macdonalds,"macdonalds","tanta,Egypt",4)
        val rectangle5=rectangle(5, R.drawable.cairo,"cairo","portsaid,Egypt",4)
        val rectangle6= rectangle(1, R.drawable.kfc,"kfc","Alexandria,Egypt",4)
        val rectangle7=rectangle(2, R.drawable.papajohnes,"papajhones","Alexandria,Egypt",5)
        val rectangle8=rectangle(3, R.drawable.bruxies,"bruxis","cairo,Egypt",2)
        val rectangle9=rectangle(4, R.drawable.macdonalds,"macdonalds","tanta,Egypt",4)
        val rectangle10=rectangle(5, R.drawable.cairo,"cairo","portsaid,Egypt",4)
        myAdapter.setData(listOf(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,
            rectangle7,rectangle8,rectangle9,rectangle5,rectangle5,rectangle5,rectangle5,rectangle5
        ,rectangle9,rectangle5,rectangle5,rectangle5,rectangle5,rectangle5,
            rectangle9,rectangle5,rectangle5,rectangle5,rectangle5,rectangle5,rectangle9,rectangle5,rectangle5,rectangle5,rectangle5,rectangle5,
            rectangle9,rectangle5,rectangle5,rectangle5,rectangle5,rectangle5,rectangle9,rectangle5,rectangle5,rectangle5,rectangle5,rectangle5))
    }

}