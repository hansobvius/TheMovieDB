package com.example.themoviedb.presentation.adapter.home.viewholder

import android.content.Context
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.presentation.adapter.home.HomeAdapter
import com.example.themoviedb.presentation.model.MovieModel

object RowAdapterContainer {

    fun createRowContainer(
        context: Context,
        title: String,
        titleView: TextView,
        listView: RecyclerView,
        homeAdapter: HomeAdapter,
        movieList: MutableList<MovieModel>?){
            titleView.text = title
            listView.apply{
                this.clipToPadding = true
                this.layoutManager = LinearLayoutManager(
                    context,
                    RecyclerView.HORIZONTAL,
                    false)
                this.isNestedScrollingEnabled = true
                this.adapter = homeAdapter
            }
            homeAdapter.apply {
                Log.i("TEST", "createRowContainer list size: ${movieList!!.count()}")
                this.initializeAdapterData(movieList!!.toList())
                this.adapterCallback = { view, position, list ->
                    HomeAdapterContainer.createPosterCard(
                        context = context,
                        position = position,
                        list = list!!,
                        view = view.itemImageView)
                }
            }
    }
}