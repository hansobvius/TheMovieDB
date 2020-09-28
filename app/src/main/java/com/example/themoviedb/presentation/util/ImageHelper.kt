package com.example.themoviedb.presentation.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageHelper {

   private fun getImageBaseUrl() = "http://image.tmdb.org/t/p/"

    private fun getImageResolution(code: Int) = when(code){
        180 -> W_180
        300 -> W_300
        else -> W_500
    }

    fun render(context: Context, url: String?, view: ImageView){
        url?.let{
            Glide.with(context).load(getImageBaseUrl() + getImageResolution(500) + url).fitCenter().into(view)
        }
    }

    const val W_180 = "w180"
    const val W_300 = "w300"
    const val W_500 = "w500"
}