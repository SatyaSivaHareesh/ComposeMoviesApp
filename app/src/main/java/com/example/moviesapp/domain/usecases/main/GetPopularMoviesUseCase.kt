package com.example.moviesapp.domain.usecases.main

import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend fun getPopularMovies(page: Int): Flow<Resource<List<Movie>>>
}
