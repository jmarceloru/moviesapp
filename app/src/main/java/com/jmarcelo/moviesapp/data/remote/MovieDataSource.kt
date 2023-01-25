package com.jmarcelo.moviesapp.data.remote

import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)
}