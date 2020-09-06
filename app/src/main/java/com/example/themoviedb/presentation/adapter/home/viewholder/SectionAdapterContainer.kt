package com.example.themoviedb.presentation.adapter.home.viewholder

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.presentation.adapter.home.RowAdapter
import com.example.themoviedb.presentation.model.MovieModel

object SectionAdapterContainer {

    fun createRowContainer(
        context: Context,
        title: String,
        titleView: TextView,
        listView: RecyclerView,
        movieList: List<MovieModel>?,
        listener: ((position: Int) -> Unit)){
        val rowAdapter = RowAdapter()
            titleView.text = title
            listView.apply{
                this.clipToPadding = true
                this.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                this.isNestedScrollingEnabled = true
                this.adapter = rowAdapter
            }
        rowAdapter.apply {
            this.initializeAdapterData(movieList!!)
            this.adapterCallback = { view, position, list ->
                RowAdapterContainer.createPosterCard(
                    context = context,
                    position = position,
                    list = list!!.toList(),
                    view = view.itemImageView)
                view.itemImageView.setOnClickListener{
                    listener(position)
                }
            }
        }
    }
}