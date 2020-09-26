package com.example.themoviedb.presentation.model.movieDetail

import com.google.gson.annotations.SerializedName

class SpokenLanguage(
    @SerializedName("iso_639_1") val isoSpoken: String,
    @SerializedName("name") val spokenName: String
)