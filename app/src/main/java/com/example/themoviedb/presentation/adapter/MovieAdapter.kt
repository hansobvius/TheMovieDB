package com.example.themoviedb.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBinderMapperImpl
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.remote.remotemodel.MovieModel
import kotlinx.android.synthetic.main.item_content.view.*

class MovieAdapter<L>(
    private val view: Int): RecyclerView.Adapter<BaseViewHolder>() {

    var adapterCallback: ((view: View, position: Int, list: MutableList<L>?) -> Unit)? = null
    private var objectList: MutableList<L>? = mutableListOf()

    fun initializeAdapterData(list: List<L>){
        this.objectList?.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(LayoutInflater.from(parent.context).inflate(view, parent, false))

    override fun getItemCount(): Int = objectList?.count() ?: OPTIONAL_SIZE_VALUE

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.initBindView { view ->
            view.root.apply{
                adapterCallback?.invoke(this, position, objectList)
            }
        }
    }

    companion object{
        const val OPTIONAL_SIZE_VALUE = 0
    }
}
