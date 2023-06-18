package com.example.sultanapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanapp.databinding.ItemRowSultanBinding

class SultanAdapter(private val listSultan: ArrayList<Sultan>): RecyclerView.Adapter<SultanAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding : ItemRowSultanBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowSultanBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listSultan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, quote, photo) = listSultan[position]
        holder.binding.imgPhoto.setImageResource(photo)
        holder.binding.tvName.text = name
        holder.binding.tvQuote.text = quote
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listSultan[holder.adapterPosition])
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Sultan)
    }
}