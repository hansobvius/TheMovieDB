package com.example.themoviedb.remote.remotemodel

import com.google.gson.annotations.SerializedName

class GenreIds(
    @SerializedName("genre_ids")val genreIDs: List<Int>)