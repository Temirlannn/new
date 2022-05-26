package com.itacademy.new23042022.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.new23042022.databinding.ActivityMainBinding
import com.itacademy.new23042022.databinding.ItemLayoutBinding
import com.itacademy.new23042022.models.inventory

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<inventory>(){
        override fun areItemsTheSame(oldItem: inventory, newItem: inventory): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: inventory, newItem: inventory): Boolean {
            TODO("Not yet implemented")
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val current = differ.currentList[position]
        holder.binding.let{
            it.category.text = current.categoryName
            it.title.text = current.title
            it.quantity.text = current.quantity.toString()
            it.image.setImageURI(Uri.parse(current.photo))
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}