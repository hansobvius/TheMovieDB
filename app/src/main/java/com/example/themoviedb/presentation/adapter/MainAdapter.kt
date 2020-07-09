package com.example.themoviedb.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
class MainAdapter<L, D>(
    private val view: Int): RecyclerView.Adapter<BaseViewHolder<D>>() where D: ViewDataBinding{

    var adapterCallback: ((view: D, position: Int, list: MutableList<L>?) -> Unit)? = null
    private var objectList: MutableList<L>? = mutableListOf()

    fun initializeAdapterData(list: List<L>){
        this.objectList?.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<D> =
        BaseViewHolder(LayoutInflater.from(parent.context).inflate(view, parent, false))

    override fun getItemCount(): Int = objectList?.count() ?: OPTIONAL_SIZE_VALUE

    override fun onBindViewHolder(holder: BaseViewHolder<D>, position: Int) {
        holder.initBindView { view ->
            view.apply{
                adapterCallback?.invoke(this as D, position, objectList)
            }
        }
    }

    companion object{
        const val OPTIONAL_SIZE_VALUE = 0
    }
}
