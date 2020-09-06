package com.example.themoviedb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.presentation.model.ModelContract

@Suppress("UNCHECKED_CAST")
abstract class BaseAdapter<O, D>:
    RecyclerView.Adapter<BaseViewHolder<D>>() where O: ModelContract, D: ViewDataBinding {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<O>(){
        override fun areItemsTheSame(oldItem: O, newItem: O): Boolean = oldItem === newItem

        override fun areContentsTheSame(oldItem: O, newItem: O): Boolean = oldItem.equals(newItem)
    }

    private val  mDiffer: AsyncListDiffer<O> = AsyncListDiffer(this, DIFF_CALLBACK)

    abstract var adapterCallback: ((view: D, position: Int, list: MutableList<O>?) -> Unit)?

    abstract fun viewContainer(): Int?

    abstract fun viewBinding(binding: D, position: Int, list: MutableList<O>?, viewType: Int)

    // FIXME - function are duplicating all list
    fun submitList(list: List<O>){
        mDiffer.submitList(list)
    }

    override fun getItemCount(): Int = mDiffer.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<D> =
        BaseViewHolder(LayoutInflater.from(parent.context).inflate(viewContainer()!!, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder<D>, position: Int) {
        holder.initBindView { view -> view.apply{ viewBinding(this as D, position, mDiffer.currentList, holder.itemViewType) } }
    }
}