package com.example.moviesapp.di

import com.example.moviesapp.domain.usecases.main.GetPopularMoviesUseCase
import com.example.moviesapp.domain.usecases.main.GetPopularMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserCaseModule {
    @Binds
    @Singleton
    abstract fun bindGetPopularMoviesUseCase(
        getPopularMoviesUseCaseImpl: GetPopularMoviesUseCaseImpl
    ): GetPopularMoviesUseCase
}
