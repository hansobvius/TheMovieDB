package com.example.themoviedb.presentation.listadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.themoviedb.R
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.databinding.RowContentBinding
import com.example.themoviedb.presentation.adapter.BaseViewHolder
import com.example.themoviedb.presentation.model.CategoryModel
import com.example.themoviedb.presentation.model.MovieModel
import com.example.themoviedb.presentation.util.ImageHelper
import kotlinx.android.synthetic.main.item_content.view.*

class RowListAdapter: ListAdapter<MovieModel, CustomViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<MovieModel>(){
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContentBinding.inflate(inflater, parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemBinding = holder.binding as ItemContentBinding
        ImageHelper.render(
            holder.itemView.context,
            getItem(position).posterPath,
            itemBinding.itemImageView
        )
    }
}