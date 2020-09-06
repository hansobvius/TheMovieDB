package com.example.themoviedb.presentation.listadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.databinding.RowContentBinding
import com.example.themoviedb.presentation.adapter.BaseViewHolder
import com.example.themoviedb.presentation.model.CategoryModel
import kotlinx.android.synthetic.main.row_content.view.*

class SectionListAdapter: ListAdapter<CategoryModel, CustomViewHolder>(Companion) {

    private val viewPool = RecyclerView.RecycledViewPool()

    private val rowSectionList: RowListAdapter = RowListAdapter()

    companion object : DiffUtil.ItemCallback<CategoryModel>(){
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean =
            oldItem.category.equals(newItem.category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowContentBinding.inflate(inflater, parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemBinding = holder.binding as RowContentBinding
        itemBinding.apply{
            movies = getItem(position)
            headerTitle.text = getItem(position).category
            movieList.setRecycledViewPool(viewPool)
            executePendingBindings()
        }
    }
}

