package com.example.moviesapp.presentation.ui.screen.main

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ui.theme.COBALT_BLUE
import com.example.moviesapp.presentation.utils.Constants.PAGE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context: Context) {
    val mViewModel = hiltViewModel<MainViewModel>()

    val listMoviesPopular = mViewModel.listMoviesPopular.collectAsState().value
    val loadingListMoviesPopular = mViewModel.loadingListMoviesPopular.collectAsState().value
    val error = mViewModel.error.collectAsState().value

    LaunchedEffect(key1 = Unit, block = {
        mViewModel.getMovies(PAGE)
    })

    if (loadingListMoviesPopular) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Center)
            )
        }
    }

    val msg = error.asString(context)
    if(msg.isNotEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Center
        ) {
            Text(
                text = msg,
                fontSize = 18.sp,
                modifier = Modifier.padding(
                    start = 15.dp, top = 0.dp, end = 15.dp, bottom = 0.dp
                )
            )
        }
    }

    if (listMoviesPopular.isNotEmpty()) {
        Scaffold(topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.app_name),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )

                }, colors = TopAppBarDefaults.smallTopAppBarColors(COBALT_BLUE)
            )
        }, modifier = Modifier
            .fillMaxSize()
            .padding(0.dp), content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listMoviesPopular) { movie ->
                    MovieItem(item = movie)
                }
            }
        })
    }
}