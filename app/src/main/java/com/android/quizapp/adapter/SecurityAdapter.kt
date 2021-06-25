package com.android.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.quizapp.callback.SecurityItemCallback
import com.android.quizapp.databinding.SecurityRecyclerItemBinding

class SecurityAdapter(private val callback: SecurityItemCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            SecurityRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).onBind()
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class ItemViewHolder(private val binding: SecurityRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            if(absoluteAdapterPosition==9){
//                binding.root.setImageResource(R.drawable.ic_touch__id)
            }else if (absoluteAdapterPosition==11){
//                binding.root.setImageResource(R.drawable.ic_delete)
            }
            else if(absoluteAdapterPosition < 10){
                binding.root.text = (absoluteAdapterPosition-1).toString()
                binding.root.setOnClickListener {
                    callback.onClickItem(absoluteAdapterPosition-1)
                }
            }else if(absoluteAdapterPosition == 11){
                binding.root.text = "0"
                binding.root.setOnClickListener {
                    callback.onClickItem(0)
                }
            }

        }
    }

}