package com.example.roadmapproject.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadmapproject.data.moviedatamodel.MovieDataResponseModel
import com.example.roadmapproject.data.moviedatamodel.MoviesResponse
import com.example.roadmapproject.repository.MovieListRepository
import com.example.roadmapproject.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository
) : ViewModel()
{
    private var _movieResponse = MutableLiveData<NetworkResult<List<MovieDataResponseModel>>>()
    val movieResponse: LiveData<NetworkResult<List<MovieDataResponseModel>>> = _movieResponse

    init {
        viewModelScope.launch {
            movieListRepository.getMovieList().collect {
                _movieResponse.postValue(it)
            }
        }
    }


}