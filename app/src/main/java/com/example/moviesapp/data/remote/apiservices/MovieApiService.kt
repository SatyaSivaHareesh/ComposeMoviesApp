package com.example.moviesapp.data.remote.apiservices


import com.example.moviesapp.data.remote.models.response.ListOfPopularMoviesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): ListOfPopularMoviesResponseDTO
}
