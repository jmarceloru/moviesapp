package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.remote.MovieDataSource

class MovieRepositoryImpl(private val movieDataSource: MovieDataSource):MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList = movieDataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = movieDataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = movieDataSource.getPopularMovies()
}