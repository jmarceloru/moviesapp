package com.jmarcelo.moviesapp.data.remote

import android.util.Log
import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.commons.SettingsUtils
import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.repository.WebService
import retrofit2.Response

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList{
        val result:MovieList = try{
            webService.getUpcomingMovies(AppConstants.API_KEY,SettingsUtils.LANGUAGE)
        }catch (ex: Exception){
            MovieList()
        }
        return result
    }


    suspend fun getTopRatedMovies(): MovieList {
        val result: MovieList = try {
            webService.getTopRatedMovies(AppConstants.API_KEY, SettingsUtils.LANGUAGE)
        } catch (ex: Exception) {
            MovieList()
        }
        return result
    }

    suspend fun getPopularMovies(): MovieList {
        val result: MovieList = try {
            webService.getPopularMovies(AppConstants.API_KEY, SettingsUtils.LANGUAGE)
        } catch (ex: Exception) {
            MovieList()
        }
        return result
    }
}