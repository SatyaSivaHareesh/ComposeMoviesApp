package com.example.moviesapp.data.remote.models.response
import com.google.gson.annotations.SerializedName
import com.example.moviesapp.data.remote.models.MovieDTO

data class ListOfPopularMoviesResponseDTO(
    val page: Int,
    val results: List<MovieDTO>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
