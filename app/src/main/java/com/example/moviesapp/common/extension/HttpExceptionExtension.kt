package com.example.moviesapp.common.extension

import com.example.moviesapp.R
import com.example.moviesapp.data.remote.models.ErrorDto
import com.example.moviesapp.data.remote.models.toErrorModel
import com.google.gson.Gson
import com.example.moviesapp.common.utils.UiText
import retrofit2.HttpException

val gson = Gson()

@Synchronized
fun HttpException.handleError(): UiText {
    val errorString = this.response()?.errorBody()?.string()
    errorString?.let {
        val errorModel = gson.fromJson(errorString, ErrorDto::class.java)?.toErrorModel()
        if (errorModel?.error != null)
            return UiText.DynamicString(errorModel.error)
        else
            return UiText.StringResource(R.string.unexpectedError)
    }
    return this.localizedMessage?.let { UiText.DynamicString(it) }
        ?: UiText.StringResource(R.string.unexpectedError)
}
