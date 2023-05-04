package com.example.rahal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rahal.data.Docuemnt
import com.example.rahal.databinding.CustomRectangleItemForRecylcerViewHomePageBinding

class RecommendedTopRatedAdapter(): RecyclerView.Adapter<RecommendedTopRatedAdapter.viewHolder>() {

    lateinit var onPlaceItemClick: ((Docuemnt)  -> Unit )

    class viewHolder(val binding: CustomRectangleItemForRecylcerViewHomePageBinding)
        : RecyclerView.ViewHolder(binding.root) {

    }

    private val diffUtil = object : DiffUtil.ItemCallback<Docuemnt>(){
        override fun areItemsTheSame(oldItem: Docuemnt, newItem: Docuemnt): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: Docuemnt, newItem: Docuemnt): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,diffUtil)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(CustomRectangleItemForRecylcerViewHomePageBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = differ.currentList[position]
        Glide.with(holder.itemView).load(data.image).into(holder.binding.imageViewId)
        holder.binding.rateTextView.text = data.rating.toString()
        holder.binding.placeTextView.text = data.name

        holder.itemView.setOnClickListener {
            onPlaceItemClick.invoke(data)
        }

    }
}