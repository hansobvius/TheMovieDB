package com.example.themoviedb.presentation.model.userReviews

import com.example.themoviedb.presentation.model.ModelContract
import com.google.gson.annotations.SerializedName

class ReviewResult(
    @SerializedName("id") val id: Long,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<UserResults>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int): ModelContract