package com.example.themoviedb.presentation.model.movieDetail

import com.example.themoviedb.presentation.model.home.GenreIds
import com.google.gson.annotations.SerializedName

class MoviesDetailModel(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdropPath") val backdropPath: String,
    @SerializedName("belongs_to_collection") val belongsToCollecion: String,
    @SerializedName("budget") val budget: Long,
    @SerializedName("genres") val genres: List<GenreIds>,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdbId: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path")val posterPath: String,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanies>,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountries>,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("revenue") val revenue: Long,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("spoken_language")val spokenLanguage: List<SpokenLanguage>,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val hasVideo: Boolean,
    @SerializedName("vote_avarage") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)