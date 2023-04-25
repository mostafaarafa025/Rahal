package com.example.rahal.remove

import androidx.recyclerview.widget.DiffUtil


class CircleDiffUtil(
    private val favoriteOldList:List<Circle>,
    private val favoriteNewList:List<Circle>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return favoriteOldList.size
    }

    override fun getNewListSize(): Int {
        return favoriteNewList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return favoriteOldList[oldItemPosition].favoriteId == favoriteNewList[newItemPosition].favoriteId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{

            favoriteOldList[oldItemPosition].favoritePlaceName != favoriteNewList[newItemPosition].favoritePlaceName ->{
                false
            }
            favoriteOldList[oldItemPosition].favoriteImageId != favoriteNewList[newItemPosition].favoriteImageId ->{
                false
            }


            else -> true
        }
    }
}