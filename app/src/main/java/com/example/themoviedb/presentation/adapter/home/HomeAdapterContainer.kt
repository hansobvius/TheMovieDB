package com.example.themoviedb.presentation.adapter.home

import android.content.Context
import android.widget.ImageView
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.remote.remotemodel.MovieModel

object HomeAdapterContainer {

    fun createPosterCard(context: Context, position: Int, list: MutableList<MovieModel>, view: ImageView){
        ImageHelper.render(
            context,
            list.get(position).posterPath,
            view
        )
    }
}