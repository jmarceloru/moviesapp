package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.local.LocalMovieDataSource
import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.model.toMovieEntity
import com.jmarcelo.moviesapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList{
        remoteMovieDataSource.getUpcomingMovies().results.forEach {
            localMovieDataSource.saveMovie(it.toMovieEntity("upcomming"))
        }
        return localMovieDataSource.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        remoteMovieDataSource.getTopRatedMovies().results.forEach {
            localMovieDataSource.saveMovie(it.toMovieEntity("toprated"))
        }
        return localMovieDataSource.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        remoteMovieDataSource.getPopularMovies().results.forEach {
            localMovieDataSource.saveMovie(it.toMovieEntity("popular"))
        }
        return localMovieDataSource.getPopularMovies()
    }
}