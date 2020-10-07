package com.example.themoviedb.repository.userReview

import com.example.themoviedb.BuildConfig
import com.example.themoviedb.presentation.model.userReviews.ReviewResult
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.movieDetail.UserReviewApi
import com.example.themoviedb.repository.RepositoryImplementation
import com.example.themoviedb.repository.popular.PopularRepository

class UserReviewRepository(
    private val remoteProject: RemoteProject<UserReviewApi>): RepositoryImplementation<ReviewResult> {

    override suspend fun fetchData(callbackService: suspend () -> ReviewResult?): ReviewResult? =
        callbackService()

    override suspend fun remoteService(id: Long?): ReviewResult? = fetchData {
        remoteProject.fetchServiceApi().getApi.getUserReview(id, BuildConfig.API_KEY, LANGUAGE).let { response ->
            return@fetchData when(response.code()){
                200 -> response.body()
                else -> null
            }
        }
    }

    companion object{
        const val OKHTTP_LOGGER = "OkHttp"
        const val LANGUAGE = "en-US"
        const val PAGE = 1
    }
}