package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity

interface MovieRepositoryLocal {
    suspend fun getUpcomingMoviesLocal(): MovieList
    suspend fun getTopRatedMoviesLocal(): MovieList
    suspend fun getPopularMoviesLocal(): MovieList
    suspend fun saveMovie(movie: MovieEntity)
}