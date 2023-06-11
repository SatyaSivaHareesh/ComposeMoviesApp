package com.example.moviesapp.data.repositories


import com.example.moviesapp.data.remote.apiservices.MovieApiService
import com.example.moviesapp.data.remote.models.response.ListOfPopularMoviesResponseDTO
import com.example.moviesapp.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): ListOfPopularMoviesResponseDTO =
        api.getPopularMovies(page)
}
