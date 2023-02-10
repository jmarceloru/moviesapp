package com.jmarcelo.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.jmarcelo.moviesapp.core.Result
import com.jmarcelo.moviesapp.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val useCase: GetMoviesUseCase) : ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            //anidamos llamadas al servidor
            emit(
                Result.Success(
                    Triple(
                        useCase.getUpcommingMovies(),
                        useCase.getTopRatedMovies(),
                        useCase.getPopularMovies()
                    )
                )
            )
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

