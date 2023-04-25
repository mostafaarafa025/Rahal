package com.example.rahal.remove

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList:List<rectangle>,
    private val newList:List<rectangle>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id ->{
                false
            }
            oldList[oldItemPosition].imageId != newList[newItemPosition].imageId ->{
                false
            }
            oldList[oldItemPosition].placeName != newList[newItemPosition].placeName ->{
                false
            }
            oldList[oldItemPosition].placeLocation != newList[newItemPosition].placeLocation ->{
                false
            }
            oldList[oldItemPosition].placeRate != newList[newItemPosition].placeRate ->{
                false
            }


            else -> true
                }
        }
}