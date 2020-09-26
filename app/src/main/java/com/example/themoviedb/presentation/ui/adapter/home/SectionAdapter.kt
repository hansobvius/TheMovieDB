package com.example.themoviedb.presentation.ui.adapter.home


import com.example.themoviedb.R
import com.example.themoviedb.databinding.RowContentBinding
import com.example.themoviedb.presentation.ui.adapter.BaseAdapter
import com.example.themoviedb.presentation.model.home.CategoryModel

class SectionAdapter: BaseAdapter<CategoryModel, RowContentBinding>() {

    override var adapterCallback: ((view: RowContentBinding, position: Int, list: MutableList<CategoryModel>?) -> Unit)? = null

    override fun viewContainer(): Int? = R.layout.row_content

    override fun viewBinding(binding: RowContentBinding, position: Int, list: MutableList<CategoryModel>?, viewType: Int) {
        adapterCallback?.invoke(binding, position, list)
    }
}