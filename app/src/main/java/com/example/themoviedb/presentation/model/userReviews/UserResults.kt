package com.example.themoviedb.presentation.model.userReviews

import com.google.gson.annotations.SerializedName

class UserResults(
    @SerializedName("author") val author: String,
    @SerializedName("content") val content: String,
    @SerializedName("id") val userResultId: String,
    @SerializedName("url") val url: String)