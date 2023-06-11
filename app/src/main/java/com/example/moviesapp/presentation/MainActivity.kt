package com.example.moviesapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.moviesapp.presentation.navigation.SetupNavHost
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ui.theme.ComposeMovieTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MovieApp() {
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.coblat_blue)
        ComposeMovieTheme {
            Scaffold(content = {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavHost(this@MainActivity)
                }
            })
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MovieApp()
    }
}