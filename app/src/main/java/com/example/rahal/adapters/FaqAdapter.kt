package com.example.rahal.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.rahal.R
import com.example.rahal.databinding.FaqItemBinding
import com.example.rahal.data.faq.FaqItem

class FaqAdapter(private val list:List<FaqItem>): RecyclerView.Adapter<FaqAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FaqItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = list[position]

        holder.titleTextView.text = ItemsViewModel.title
        holder.bodyTextView.text = ItemsViewModel.body

            holder.cardView.setOnClickListener {
                if (holder.bodyTextView.isGone){
                    holder.titleTextView.setCompoundDrawablesWithIntrinsicBounds(0,0,
                        R.drawable.ic_arrow_up,0,)
                    holder.bodyTextView.isVisible = true
                }else {
                    holder.titleTextView.setCompoundDrawablesWithIntrinsicBounds(0,0,
                        R.drawable.ic_arrow_down,0,)
                    holder.bodyTextView.isGone = true
                }
            }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: List<FaqItem>)
    }

    class ViewHolder(var binding: FaqItemBinding): RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.titleTextView
        val bodyTextView: TextView = binding.bodyTextView
        val cardView:CardView = binding.cardView
    }
}