package com.example.themoviedb.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.presentation.model.ModelContract

@Suppress("UNCHECKED_CAST")
abstract class BaseAdapter<O, D>:
    RecyclerView.Adapter<BaseViewHolder<D>>(), IAdapter<O> where O: ModelContract, D: ViewDataBinding {

    abstract var adapterCallback: ((view: D, position: Int, list: MutableList<O>?) -> Unit)?

    abstract fun viewContainer(): Int?

    abstract fun viewBinding(binding: D, position: Int, list: MutableList<O>?, viewType: Int)

    override var mDiffList: AsyncListDiffer<O>? = AsyncListDiffer(this@BaseAdapter, object : DiffUtil.ItemCallback<O>() {
        override fun areItemsTheSame(oldItem: O, newItem: O): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: O, newItem: O): Boolean = oldItem.equals(newItem)
    })

    override fun initializeAdapterData(list: List<O>){
        mDiffList?.submitList(list)
    }

    override fun getItemCount(): Int = mDiffList?.currentList?.size ?: OPTIONAL_SIZE_VALUE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<D> =
        BaseViewHolder(LayoutInflater.from(parent.context).inflate(viewContainer()!!, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder<D>, position: Int) {
        holder.initBindView { view -> view.apply{ viewBinding(this as D, position, mDiffList?.currentList, holder.itemViewType) } }
    }

    companion object{
        const val OPTIONAL_SIZE_VALUE = 0
    }
}