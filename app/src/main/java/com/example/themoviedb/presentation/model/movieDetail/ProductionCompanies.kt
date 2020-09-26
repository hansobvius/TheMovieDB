package com.example.themoviedb.presentation.model.movieDetail

import com.google.gson.annotations.SerializedName

class ProductionCompanies(
    @SerializedName("id") val companyId: Long,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("name") val companyName: String,
    @SerializedName("origin_country") val originCountry: String
)