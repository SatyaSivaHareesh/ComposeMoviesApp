package com.example.moviesapp.domain.repositories

import com.example.moviesapp.data.remote.models.response.ListOfPopularMoviesResponseDTO


interface MovieRepository {
    suspend fun getPopularMovies(page: Int): ListOfPopularMoviesResponseDTO

}
