package com.example.moviesapp.domain.usecases.main

import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.UiText
import com.example.moviesapp.domain.mappers.MovieMapper
import com.example.moviesapp.domain.repositories.MovieRepository
import com.example.moviesapp.utils.MockHelper
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetPopularMoviesUseCaseImplTest {
    private lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var mapper: MovieMapper

    private val page: Int = 0

    @Before
    fun setUp() {
        getPopularMoviesUseCase = GetPopularMoviesUseCaseImpl(movieRepository, mapper)
    }

    @Test
    fun `check getPopularMovies() success case`() = runBlocking {
        // when
        whenever(movieRepository.getPopularMovies(page)).thenAnswer { MockHelper.popularMovieListDto }
        val result = getPopularMoviesUseCase.getPopularMovies(page)
        val flowList = result.toList()
        // then
        assertThat(flowList[0]).isInstanceOf(Resource.Loading::class.java)
        assertThat(flowList[1]).isInstanceOf(Resource.Success::class.java)
    }

    @Test
    fun `check getPopularMovies() http exception error case`() = runBlocking {
        // when
        whenever(movieRepository.getPopularMovies(page)).thenAnswer { throw MockHelper.getHttpException() }
        val result = getPopularMoviesUseCase.getPopularMovies(page)
        val flowList = result.toList()
        // then
        assertThat(flowList[0]).isInstanceOf(Resource.Loading::class.java)
        assertThat(flowList[1]).isInstanceOf(Resource.Error::class.java)
        assertThat(flowList[1].message).isInstanceOf(UiText.DynamicString::class.java)
    }

    @Test
    fun `check getPopularMovies() io exception error case`() = runBlocking {
        // when
        whenever(movieRepository.getPopularMovies(page)).thenAnswer { throw MockHelper.ioException }
        val result = getPopularMoviesUseCase.getPopularMovies(page)
        val flowList = result.toList()
        // then

        assertThat(flowList[0]).isInstanceOf(Resource.Loading::class.java)
        assertThat(flowList[1]).isInstanceOf(Resource.Error::class.java)
        assertThat(flowList[1].message).isInstanceOf(UiText.StringResource::class.java)
    }
}