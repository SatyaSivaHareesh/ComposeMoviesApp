package com.example.moviesapp.presentation.navigation

import com.example.moviesapp.presentation.utils.ScreensConstants

sealed class NavRoute(val route: String) {

    object Main : NavRoute(route = ScreensConstants.Screens.MAIN_SCREEN)
}