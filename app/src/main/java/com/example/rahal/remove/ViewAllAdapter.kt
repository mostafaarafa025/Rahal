package com.example.rahal.remove

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rahal.databinding.ViewAllActivitiesItemBinding

class ViewAllAdapter: RecyclerView.Adapter<ViewAllAdapter.ViewHolder>() {
    private var oldPersonList= emptyList<rectangle>()
    class ViewHolder(var viewBinding: ViewAllActivitiesItemBinding):
        RecyclerView.ViewHolder(viewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewAllActivitiesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return oldPersonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.placeNameTextView.text=oldPersonList[position].placeName
        holder.viewBinding.locationPlace.text=oldPersonList[position].placeLocation
        holder.viewBinding.rateTextView.text=oldPersonList[position].placeRate.toString()
        holder.viewBinding.imageCircleId.setImageResource(oldPersonList[position].imageId)
    }
    fun setData(newPersonList:List<rectangle>){
        val diffUtil=MyDiffUtil(oldPersonList,newPersonList)
        val diffResults= DiffUtil.calculateDiff(diffUtil)
        oldPersonList=newPersonList
        diffResults.dispatchUpdatesTo(this)
    }
}