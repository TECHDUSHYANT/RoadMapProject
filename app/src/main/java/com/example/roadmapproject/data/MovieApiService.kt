package com.example.roadmapproject.data


import com.example.roadmapproject.data.moviedatamodel.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface MovieApiService {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getMovieList(): MoviesResponse


}