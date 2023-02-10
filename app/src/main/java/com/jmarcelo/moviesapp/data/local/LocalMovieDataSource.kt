package com.jmarcelo.moviesapp.data.local

import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity
import com.jmarcelo.moviesapp.data.modeldatabase.toMovieList
import javax.inject.Inject

class LocalMovieDataSource @Inject constructor (private val movieDao: MovieDao) {

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

    suspend fun deleteMovie(movie: MovieEntity){
        movieDao.deleteMovie(movie)
    }

    suspend fun deleteMovieByIdAndType(id:Int,type:String){
        movieDao.deleteMovieByIdAndType(id,type)
    }

}