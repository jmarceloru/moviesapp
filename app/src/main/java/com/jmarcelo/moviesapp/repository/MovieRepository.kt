package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.model.MovieList

interface MovieRepository {

    suspend fun getUpcomingMovies():MovieList
    suspend fun getTopRatedMovies():MovieList
    suspend fun getPopularMovies():MovieList
}