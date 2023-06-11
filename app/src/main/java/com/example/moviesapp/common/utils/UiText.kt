package com.example.moviesapp.common.utils

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {
    object Init : UiText()
    data class DynamicString(val value: String) : UiText()
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any
    ) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is Init -> ""
            is DynamicString -> value
            is StringResource -> context.getString(resId, *args)
        }
    }
}
