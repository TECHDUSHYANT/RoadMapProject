package com.example.roadmapproject.di

import com.example.roadmapproject.R
import com.example.roadmapproject.data.MovieApiService
import com.example.roadmapproject.utils.Constants
import com.example.roadmapproject.utils.HeaderAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApis(): MovieApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(MovieApiService::class.java)
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
             readTimeout(3, TimeUnit.MINUTES)
                 .addInterceptor(HeaderAuth("Bearer","eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmN2RlZThmMWVjNTQ4MzgxZjAxODk5NDhhNTIzNGMwMiIsInN1YiI6IjYzN2RhYmE1NmEzMDBiMDA3ZDU4YzQ2MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gWYWXpmns-eJ0gcGQ5WoIdrh7MpqSz2nVpKHr4a-MTA"))
            .connectTimeout(3, TimeUnit.MINUTES)
    }.build()


}