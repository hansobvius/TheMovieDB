package com.example.themoviedb.presentation.adapter.home

import com.example.themoviedb.R
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.presentation.adapter.BaseAdapter
import com.example.themoviedb.remote.remotemodel.MovieModel

class HomeAdapter: BaseAdapter<MovieModel, ItemContentBinding>() {

    override var adapterCallback: ((view: ItemContentBinding, position: Int, list: MutableList<MovieModel>?) -> Unit)? = null

    override var viewContainer: Int? = R.layout.item_content

    override fun viewBinding(binding: ItemContentBinding, position: Int, list: MutableList<MovieModel>?) {
        adapterCallback?.invoke(binding, position, list)
    }
}