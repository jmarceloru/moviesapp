package com.jmarcelo.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.jmarcelo.moviesapp.core.Result
import com.jmarcelo.moviesapp.usecase.GetMoviesUseCase

class MovieViewModel(private val useCase: GetMoviesUseCase): ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        emit(Result.Loading())
        try {
            //anidamos llamadas al servidor
           emit(Result.Success(Triple(useCase.getUpcommingMovies(),useCase.getTopRatedMovies(),useCase.getPopularMovies())))
        }catch (e: Exception){
            emit(Result.Failure(e))
        }
    }
}

class MovieViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetMoviesUseCase::class.java).newInstance(getMoviesUseCase)
    }
}