package com.jmarcelo.moviesapp.data.remote

import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.commons.SettingsUtils
import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.repository.WebService
import retrofit2.Response

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): Result<MovieList>{
        val response:Response<MovieList>
        val result = try {
            response = webService.getUpcomingMovies(AppConstants.API_KEY, SettingsUtils.LANGUAGE)
            if (response.isSuccessful) {
                Result.success(response.body() ?: MovieList())
            } else {
                Result.failure(Throwable("NO SE PUDO OBTENER LAS PELICULAS UPCOMMING"))
            }
        } catch (ex: Exception) {
            Result.failure(ex)
        }
        return result
    }

    suspend fun getTopRatedMovies(): Result<MovieList> {
        val response:Response<MovieList>
        val result = try {
            response = webService.getTopRatedMovies(AppConstants.API_KEY, SettingsUtils.LANGUAGE)
            if (response.isSuccessful) {
                Result.success(response.body() ?: MovieList())
            } else {
                Result.failure(Throwable("NO SE PUDO OBTENER LAS PELICULAS TOP RATED"))
            }
        } catch (ex: Exception) {
            Result.failure(ex)
        }
        return result
    }

    suspend fun getPopularMovies(): Result<MovieList> {
        val response:Response<MovieList>
        val result = try {
            response = webService.getPopularMovies(AppConstants.API_KEY, SettingsUtils.LANGUAGE)
            if (response.isSuccessful) {
                Result.success(response.body() ?: MovieList())
            } else {
                Result.failure(Throwable("NO SE PUDO OBTENER LAS PELICULAS POPULAR"))
            }
        } catch (ex: Exception) {
            Result.failure(ex)
        }
        return result
    }
}