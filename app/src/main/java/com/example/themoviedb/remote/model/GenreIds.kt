package com.example.themoviedb.remote.model

import com.google.gson.annotations.SerializedName

class GenreIds(
    @SerializedName("genre_ids")val genreIDs: List<Int>)