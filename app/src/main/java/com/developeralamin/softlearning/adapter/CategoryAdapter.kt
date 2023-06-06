package com.developeralamin.softlearning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.developeralamin.softlearning.databinding.PostItemLayoutBinding
import com.developeralamin.softlearning.interfacs.CategoryClick
import com.developeralamin.softlearning.model.category.CategoryModel

class CategoryAdapter
    (
    val context: Context,
    val list: CategoryModel,
    val listener : CategoryClick
) : Adapter<CategoryAdapter.PostViewHolder>() {

    inner class PostViewHolder(
        val binding: PostItemLayoutBinding
    ) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostItemLayoutBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        
        holder.binding.title.text = list[position].name
        
        holder.itemView.setOnClickListener {
            Toast.makeText(context, list[position].name, Toast.LENGTH_SHORT).show()
            listener.onCategoryClick(list[position].id.toString())
        }
    }
}