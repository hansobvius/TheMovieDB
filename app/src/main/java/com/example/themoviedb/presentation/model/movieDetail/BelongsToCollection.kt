package com.example.themoviedb.presentation.model.movieDetail

import com.google.gson.annotations.SerializedName

class BelongsToCollection(
    @SerializedName("id") val collectionId: Long,
    @SerializedName("name") val collectionName: String,
    @SerializedName("poster_path") val collectionPosterPath: String,
    @SerializedName("backdrop_path") val collectionBackdropPath: String
)