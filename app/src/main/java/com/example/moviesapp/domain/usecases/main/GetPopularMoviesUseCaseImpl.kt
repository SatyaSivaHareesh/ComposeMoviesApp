package com.example.moviesapp.domain.usecases.main

import com.example.moviesapp.R
import com.example.moviesapp.common.extension.handleError
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.UiText
import com.example.moviesapp.domain.mappers.MovieMapper
import com.example.moviesapp.domain.models.Movie
import com.example.moviesapp.domain.repositories.MovieRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository,
    private val mapper: MovieMapper
) :
    GetPopularMoviesUseCase {
    override suspend fun getPopularMovies(page: Int): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getPopularMovies(page = page).results
            emit(Resource.Success(data = response.map(mapper::fromDtoToDomain)))
        } catch (e: HttpException) {
            emit(Resource.Error(e.handleError()))
        } catch (e: IOException) {
            emit(Resource.Error(UiText.StringResource(R.string.couldntReachServerError)))
        }
    }
}
