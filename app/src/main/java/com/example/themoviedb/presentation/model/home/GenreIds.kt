package com.example.themoviedb.presentation.model.home

import com.google.gson.annotations.SerializedName

class GenreIds(
    @SerializedName("genre_ids")val genreIDs: List<Int>,
    @SerializedName("name") val genreName: String)