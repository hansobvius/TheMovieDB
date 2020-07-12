package com.example.themoviedb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.themoviedb.R
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.remote.remotemodel.MovieModel

class HomeAdapter: BaseAdapter<MovieModel, ItemContentBinding>() {

    override var adapterCallback: ((view: ItemContentBinding, position: Int, list: MutableList<MovieModel>?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemContentBinding> =
        BaseViewHolder(LayoutInflater.from(parent.context).inflate(CONTENT_HOLDER, parent, false))

    override fun viewBinding(binding: ItemContentBinding, position: Int, list: MutableList<MovieModel>?) {
        adapterCallback?.invoke(binding, position, list)
    }

    companion object{
        const val CONTENT_HOLDER = R.layout.item_content
    }
}