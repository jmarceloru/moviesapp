package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey:String,@Query("language") language:String): Response<MovieList>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String,@Query("language") language:String): Response<MovieList>

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String,@Query("language") language:String): Response<MovieList>
}