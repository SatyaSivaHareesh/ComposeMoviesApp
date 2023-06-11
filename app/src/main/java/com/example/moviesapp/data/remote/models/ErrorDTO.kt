package com.example.moviesapp.data.remote.models

import com.example.moviesapp.domain.models.ErrorModel

data class ErrorDto(val error: String?)

fun ErrorDto.toErrorModel(): ErrorModel = ErrorModel(error = error)
