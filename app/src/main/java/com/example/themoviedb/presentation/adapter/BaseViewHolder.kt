package com.example.themoviedb.presentation.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(private val view: View): RecyclerView.ViewHolder(view){

    fun initBindView(callbackViewHolder: (binding: ViewDataBinding) -> Unit){
        val viewBinding: ViewDataBinding = DataBindingUtil.bind(view)!!
        callbackViewHolder(viewBinding)
    }
}

