package com.example.moviesapp.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.presentation.ui.screen.main.MainScreen

@Composable
fun SetupNavHost(context: Context) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Main.route
    ) {

        composable(route = NavRoute.Main.route) {
            MainScreen(context)
        }

    }
}