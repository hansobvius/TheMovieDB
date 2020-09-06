package com.example.themoviedb.presentation.adapter.home


import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.themoviedb.R
import com.example.themoviedb.databinding.RowContentBinding
import com.example.themoviedb.presentation.adapter.BaseAdapter
import com.example.themoviedb.presentation.model.CategoryModel

class SectionAdapter: BaseAdapter<CategoryModel, RowContentBinding>() {

    override var adapterCallback: ((view: RowContentBinding, position: Int, list: MutableList<CategoryModel>?) -> Unit)? = null

    override fun viewContainer(): Int? = R.layout.row_content

    override fun viewBinding(binding: RowContentBinding, position: Int, list: MutableList<CategoryModel>?, viewType: Int) {
        Log.i("TEST", "SectionAdapter list size: ${list!!.size}")
        adapterCallback?.invoke(binding, position, list)
    }
}