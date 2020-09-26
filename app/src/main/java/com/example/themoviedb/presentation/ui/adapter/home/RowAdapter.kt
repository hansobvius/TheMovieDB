package com.example.themoviedb.presentation.ui.adapter.home

import com.example.themoviedb.R
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.presentation.ui.adapter.BaseAdapter
import com.example.themoviedb.presentation.model.home.MovieModel

class RowAdapter: BaseAdapter<MovieModel, ItemContentBinding>() {

    override var adapterCallback: ((view: ItemContentBinding, position: Int, list: MutableList<MovieModel>?) -> Unit)? = null

    override fun viewContainer(): Int? = R.layout.item_content

    override fun viewBinding(binding: ItemContentBinding, position: Int, list: MutableList<MovieModel>?, viewType: Int) {
        adapterCallback?.invoke(binding, position, list)
    }
}