package com.example.themoviedb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.remote.remotemodel.ModelContract

@Suppress("UNCHECKED_CAST")
class MainAdapter<L, D>(
    private val view: Int):
    RecyclerView.Adapter<BaseViewHolder<D>>() where D: ViewDataBinding, L : ModelContract {

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

    override fun getItemViewType(position: Int): Int =
        when (objectList?.get(position)) {
            is L -> VIEW_TYPE_1
            else -> VIEW_TYPE_0
        }

    companion object{
        const val OPTIONAL_SIZE_VALUE = 0
        const val VIEW_TYPE_0 = 0
        const val VIEW_TYPE_1 = 1
    }
}
