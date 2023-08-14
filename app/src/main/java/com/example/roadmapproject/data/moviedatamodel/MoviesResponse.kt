package com.example.roadmapproject.data.moviedatamodel

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
@SerializedName("results") var movies : List<MovieDataResponseModel>
)