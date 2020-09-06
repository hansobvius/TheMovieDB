package com.example.themoviedb.presentation.listadapter

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.presentation.model.MovieModel

@BindingAdapter(value = ["setMovies"])
fun RecyclerView.setMovies(movies: List<MovieModel>?) {
    if (movies != null) {
        val rowListAdapter = RowListAdapter()
        rowListAdapter.submitList(movies)
        clipToPadding = true
        layoutManager = LinearLayoutManager(
            this.context,
            RecyclerView.HORIZONTAL,
            false
        )
        setHasFixedSize(true)
        adapter = rowListAdapter
    }
}