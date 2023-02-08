package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.model.MovieList

interface MovieRepository {

    suspend fun getUpcomingMovies():Result<MovieList>
    suspend fun getTopRatedMovies():Result<MovieList>
    suspend fun getPopularMovies():Result<MovieList>

}