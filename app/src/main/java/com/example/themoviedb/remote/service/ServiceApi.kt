package com.example.themoviedb.remote.service

import com.example.themoviedb.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import java.util.concurrent.TimeUnit

const val TIMEOUT: Long = 30

object ServiceApi {

    fun getApiService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttp)
            .build()
    }

    private val okHttp =
        OkHttpClient.Builder()
            .addInterceptor(HttpInterceptor())
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()


    class HttpInterceptor: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Content-type", "application/json")
                .addHeader("Accept", "application/json")
                .build()
            return chain.proceed(request)
        }
    }
}