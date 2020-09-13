package com.example.themoviedb.presentation.ui.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<D>(private val view: View):
    RecyclerView.ViewHolder(view) where D: ViewDataBinding{

    fun initBindView(callbackViewHolder: (binding: ViewDataBinding) -> Unit){
        val viewBinding: D = DataBindingUtil.bind(view)!!
        callbackViewHolder(viewBinding)
    }
}

