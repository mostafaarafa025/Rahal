package com.example.rahal.remove

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.rahal.databinding.SliderItemBinding
import java.util.*

class SliderAdapter(val items: List<SliderItem>, val viewPager2: ViewPager2) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SliderItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SliderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.imageView.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun startAutoSlider() {
        val handler = Handler()

        val runnable = object : Runnable {
            override fun run() {
                viewPager2.currentItem = (viewPager2.currentItem + 1) % items.size
                handler.postDelayed(this, 2000) // 3 seconds delay
            }
        }

        handler.postDelayed(runnable, 2000) // 3 seconds delay

    }
}
