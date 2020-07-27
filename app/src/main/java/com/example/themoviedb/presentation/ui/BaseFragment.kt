package com.example.themoviedb.presentation.ui

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.themoviedb.R
import com.example.themoviedb.presentation.adapter.BaseAdapter
import com.example.themoviedb.remote.model.ModelContract

abstract class BaseFragment<L, D, A: BaseAdapter<L,D>>: Fragment() where L: ModelContract, D: ViewDataBinding {

    val view = R.layout.item_content

    abstract fun getBindingView(binding: D)

    abstract fun adapterContainer(adapter: A)
}