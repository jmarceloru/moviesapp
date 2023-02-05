package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity

interface MovieRepository {

    suspend fun getUpcomingMovies():Result<MovieList>
    suspend fun getTopRatedMovies():Result<MovieList>
    suspend fun getPopularMovies():Result<MovieList>

    suspend fun getUpcomingMoviesLocal():MovieList
    suspend fun getTopRatedMoviesLocal():MovieList
    suspend fun getPopularMoviesLocal():MovieList

    suspend fun saveMovie(movie: MovieEntity)
}