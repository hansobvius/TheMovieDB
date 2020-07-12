package com.example.themoviedb.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.remote.remotemodel.ModelContract
import com.example.themoviedb.remote.remotemodel.MovieModel

@Suppress("UNCHECKED_CAST")
abstract class BaseAdapter<O, D>:
    RecyclerView.Adapter<BaseViewHolder<D>>() where O : ModelContract, D: ViewDataBinding {

    private var objectList: MutableList<O>? = mutableListOf()
    abstract var adapterCallback: ((view: D, position: Int, list: MutableList<O>?) -> Unit)?

    abstract fun viewBinding(binding: D, position: Int, list: MutableList<O>?)

    fun initializeAdapterData(list: List<O>){
        this.objectList?.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = objectList?.count() ?: OPTIONAL_SIZE_VALUE

    override fun onBindViewHolder(holder: BaseViewHolder<D>, position: Int) {
        holder.initBindView { view ->
            view.apply{
                viewBinding(this as D, position, objectList)
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (objectList?.get(position)) {
            is O -> VIEW_TYPE_1
            else -> VIEW_TYPE_0
        }

    companion object{
        const val OPTIONAL_SIZE_VALUE = 0
        const val VIEW_TYPE_0 = 0
        const val VIEW_TYPE_1 = 1
    }
}