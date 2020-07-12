package com.example.themoviedb.remote.remotemodel

import com.google.gson.annotations.SerializedName

class MovieModel(
    @SerializedName("popularity")val popularity: Double,
    @SerializedName("vote_count")val voteCount: Int,
    @SerializedName("video")val video: Boolean,
    @SerializedName("poster_path")val posterPath: String,
    @SerializedName("id")val id: Long,
    @SerializedName("adult")val adult: Boolean,
    @SerializedName("backdrop_path")val backdropPath: String,
    @SerializedName("original_language")val originalLanguage: String,
    @SerializedName("original_title")val originalTitle: String,
    @SerializedName("title")val title: String,
    @SerializedName("vote_avarage")val voteAvarage: Float,
    @SerializedName("overview")val overview: String,
    @SerializedName("release_date")val releaseDate: String): ModelContract