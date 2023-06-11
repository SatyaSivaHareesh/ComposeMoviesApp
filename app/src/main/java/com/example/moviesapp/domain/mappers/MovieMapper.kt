package com.example.moviesapp.domain.mappers

import com.example.moviesapp.data.remote.models.MovieDTO
import com.example.moviesapp.domain.models.Movie

class MovieMapper {

    fun fromDtoToDomain(movieDto: MovieDTO): Movie = with(movieDto) {
        Movie(
            id = id,
            posterPath = posterPath ?: "",
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            title = title,
            overview = overview,
            genre = if (!genres.isNullOrEmpty()) genres[0].name else "",
            runtime = runtime,
            popularity = popularity
        )
    }
}
