package com.example.themoviedb.presentation.model.movieDetail

import com.google.gson.annotations.SerializedName

class ProductionCountries(
    @SerializedName("iso_3166_1") val isoCountry: String,
    @SerializedName("name") val productionCountryName: String
)