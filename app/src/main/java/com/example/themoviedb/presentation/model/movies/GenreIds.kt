package com.example.themoviedb.presentation.model.movies

import com.google.gson.annotations.SerializedName

class GenreIds(
    @SerializedName("genre_ids")val genreIDs: List<Int>,
    @SerializedName("name") val genreName: String)