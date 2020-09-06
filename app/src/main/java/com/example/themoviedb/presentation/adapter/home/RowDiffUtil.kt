package com.example.themoviedb.presentation.adapter.home

import androidx.recyclerview.widget.DiffUtil
import com.example.themoviedb.presentation.model.MovieModel

class RowDiffUtil(val new: List<MovieModel>, val old: List<MovieModel>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        old.get(oldItemPosition) == new.get(newItemPosition)

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        old.get(oldItemPosition).equals(new.get(newItemPosition))

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}