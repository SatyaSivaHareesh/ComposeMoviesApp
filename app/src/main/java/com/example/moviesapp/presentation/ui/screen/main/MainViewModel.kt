package com.example.moviesapp.presentation.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.UiText
import com.example.moviesapp.domain.models.Movie
import com.example.moviesapp.domain.usecases.main.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val isLoadingListMoviesPopular = MutableStateFlow(false)
    val loadingListMoviesPopular = isLoadingListMoviesPopular.asStateFlow()

    private val _error = MutableStateFlow<UiText>(UiText.Init)
    val error = _error.asStateFlow()

    private val _listMoviesPopular = MutableStateFlow<List<Movie>>(listOf())
    val listMoviesPopular = _listMoviesPopular.asStateFlow()

    private val _state = MutableStateFlow<MainViewState>(MainViewState.Init)
    fun getViewState(): StateFlow<MainViewState> = _state.asStateFlow()

    fun setLoading(isLoading: Boolean) {
        _state.value = MainViewState.Loading(isLoading)
    }

    fun getMovies(page: Int) {
        viewModelScope.launch {
            getMoviesUseCase.getPopularMovies(page).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        setLoading(false)
                        _state.value = MainViewState.Error(result.message)

                        isLoadingListMoviesPopular.emit(false)
                        _error.emit(result.message)
                    }
                    is Resource.Loading -> {
                        setLoading(true)
                        isLoadingListMoviesPopular.emit(true)
                    }
                    is Resource.Success -> {
                        setLoading(false)
                        if (result.data.isNullOrEmpty()) {
                            _state.value = MainViewState.SuccessWithEmptyData
                        } else {
                            _state.value = MainViewState.Success(result.data)
                            _listMoviesPopular.emit(result.data)
                        }
                    }
                }
            }.launchIn(this)
        }
    }

    sealed class MainViewState {
        object Init : MainViewState()
        data class Loading(val isLoading: Boolean) : MainViewState()
        data class Success(val data: List<Movie>) : MainViewState()
        object SuccessWithEmptyData : MainViewState()
        data class Error(val error: UiText) : MainViewState()
    }
}