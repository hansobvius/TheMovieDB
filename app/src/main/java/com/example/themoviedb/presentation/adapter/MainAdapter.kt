package com.example.themoviedb.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter<M>(
    private val view: View,
    private val bindViewModel: (BaseViewHolder) -> Unit): RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var listModel: List<M>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bindViewModel(holder)
    }
}


class BaseViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun initBindView(callbackViewHolder: () -> Unit) = callbackViewHolder()
}