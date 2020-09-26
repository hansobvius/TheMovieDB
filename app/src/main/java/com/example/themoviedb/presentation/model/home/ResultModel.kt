package com.example.themoviedb.presentation.model.home

import com.google.gson.annotations.SerializedName

class ResultModel(
    @SerializedName("page")val page: Int,
    @SerializedName("total_results")val totalResults: Long,
    @SerializedName("total_pages")val totalPages: Int,
    @SerializedName("results")val results: List<MovieModel>)