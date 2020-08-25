package com.example.themoviedb.presentation.adapter.home

import com.example.themoviedb.R
import com.example.themoviedb.databinding.RowContentBinding
import com.example.themoviedb.presentation.adapter.BaseAdapter
import com.example.themoviedb.presentation.model.CategoryModel

class RowAdapter: BaseAdapter<CategoryModel, RowContentBinding>() {

    override var adapterCallback: ((view: RowContentBinding, position: Int, list: MutableList<CategoryModel>?) -> Unit)? = null

    override fun viewContainer(): Int? = R.layout.row_content

    override fun viewBinding(binding: RowContentBinding, position: Int, list: MutableList<CategoryModel>?) {
        adapterCallback?.invoke(binding, position, list)
    }
}