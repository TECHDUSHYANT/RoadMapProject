package com.example.roadmapproject.repository

import com.example.roadmapproject.data.MovieApiService
import com.example.roadmapproject.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepository @Inject constructor(private val movieapiservice: MovieApiService) {

    suspend fun getMovieList()  = flow {
        emit(NetworkResult.Loading(true))
        val response = movieapiservice.getMovieList()
        emit(NetworkResult.Success(response.movies))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }

}
