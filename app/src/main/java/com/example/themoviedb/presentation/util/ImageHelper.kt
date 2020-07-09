package com.example.themoviedb.presentation.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageHelper {

    fun render(context: Context, url: String, view: ImageView){
        Glide.with(context).load(url).fitCenter().into(view)
    }
}