package com.example.rahal.remove

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rahal.databinding.CustomRectangleItemForPlansBinding

class PlansAdapter: RecyclerView.Adapter<PlansAdapter.ViewHolder>() {
    private var oldCircle= emptyList<Circle>()

    class ViewHolder(var binding: CustomRectangleItemForPlansBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomRectangleItemForPlansBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return PlansAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.imageView.setImageResource(oldCircle[position].favoriteImageId)
        holder.binding.textView.text=oldCircle[position].favoritePlaceName
    }

    override fun getItemCount(): Int {
        return  oldCircle.size
    }
    fun setCircleData(newCircle:List<Circle>){
        val diffUtil=CircleDiffUtil(oldCircle,newCircle)
        val diffResults= DiffUtil.calculateDiff(diffUtil)
        oldCircle=newCircle
        diffResults.dispatchUpdatesTo(this)
    }

}