package com.example.themoviedb.presentation.adapter.home.viewholder

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.remote.model.MovieModel

object HomeAdapterContainer {

    fun createPosterCard(context: Context, position: Int, list: MutableList<MovieModel>, view: ImageView){
        Log.i("TEST", "cratePosterCard list size: ${list.count()}")
        ImageHelper.render(
            context,
            list.get(position).posterPath,
            view
        )
    }
}