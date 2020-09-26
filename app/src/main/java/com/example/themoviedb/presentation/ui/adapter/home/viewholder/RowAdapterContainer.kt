package com.example.themoviedb.presentation.ui.adapter.home.viewholder

import android.content.Context
import android.widget.ImageView
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.model.home.MovieModel

object RowAdapterContainer {

    fun createPosterCard(context: Context, position: Int, list: List<MovieModel>, view: ImageView){
        ImageHelper.render(
            context,
            list.get(position).posterPath,
            view
        )
    }
}