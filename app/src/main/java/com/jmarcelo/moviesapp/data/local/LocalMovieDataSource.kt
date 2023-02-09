package com.jmarcelo.moviesapp.data.local

import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity
import com.jmarcelo.moviesapp.data.modeldatabase.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {

    suspend fun getUpcomingMovies(): MovieList{
        return movieDao.getAllMovies().filter { it.movie_type == "upcomming" }.toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "toprated" }.toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "popular" }.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.insertMovie(movie)
    }

    suspend fun saveAllMovie(movieList: List<MovieEntity>){
        movieDao.insertAllMovie(movieList)
    }

}