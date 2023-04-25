package com.example.rahal.remove

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rahal.databinding.CustomRectangleItemForRecylcerViewHomePageBinding
import com.example.rahal.databinding.CustomRectangleItemForRecylerViewBinding

class RectangleAdapter: RecyclerView.Adapter<RectangleAdapter.ViewHolder>() {
    private var oldPersonList= emptyList<rectangle>()
    class ViewHolder(var viewBinding:CustomRectangleItemForRecylcerViewHomePageBinding):RecyclerView.ViewHolder(viewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomRectangleItemForRecylcerViewHomePageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return oldPersonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.placeTextView.text=oldPersonList[position].placeName
        holder.viewBinding.locationPlace.text=oldPersonList[position].placeLocation
        holder.viewBinding.rateTextView.text=oldPersonList[position].placeRate.toString()
        holder.viewBinding.imageViewId.setImageResource(oldPersonList[position].imageId)
    }
    fun setData(newPersonList:List<rectangle>){
        val diffUtil=MyDiffUtil(oldPersonList,newPersonList)
        val diffResults= DiffUtil.calculateDiff(diffUtil)
        oldPersonList=newPersonList
        diffResults.dispatchUpdatesTo(this)
        }
   }