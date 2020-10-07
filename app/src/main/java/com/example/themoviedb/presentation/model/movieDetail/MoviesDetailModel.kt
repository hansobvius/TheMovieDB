package com.example.themoviedb.presentation.model.movieDetail

import com.example.themoviedb.presentation.model.ModelContract
import com.example.themoviedb.presentation.model.movies.GenreIds
import com.google.gson.annotations.SerializedName

class MoviesDetailModel(
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("belongs_to_collection") val belongsToCollection: BelongsToCollection?,
    @SerializedName("budget") val budget: Long?,
    @SerializedName("genres") val genres: List<GenreIds>?,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("id") val id: Long?,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path")val posterPath: String?,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanies>?,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountries>?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("revenue") val revenue: Long?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("spoken_language")val spokenLanguage: List<SpokenLanguage>?,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("video") val hasVideo: Boolean?,
    @SerializedName("vote_avarage") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Int?
): ModelContract