package com.example.roadmapproject.data.moviedatamodel

import com.google.gson.annotations.SerializedName

data class MovieDataResponseModel(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val posterPath: String

)