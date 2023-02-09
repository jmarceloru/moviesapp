package com.jmarcelo.moviesapp.repository

import com.jmarcelo.moviesapp.data.local.LocalMovieDataSource
import com.jmarcelo.moviesapp.data.model.MovieList
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity
import com.jmarcelo.moviesapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource
) : MovieRepository,MovieRepositoryLocal {

    override suspend fun getUpcomingMovies(): Result<MovieList> {
        return remoteMovieDataSource.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): Result<MovieList> {
        return remoteMovieDataSource.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): Result<MovieList> {
        return remoteMovieDataSource.getPopularMovies()
    }

    //esto es lo correcto ? se hace con el fin de que el caso de uso solo tenga dependencia con el repositorio
    // y no conozca el origen de los datos
    override suspend fun getUpcomingMoviesLocal(): MovieList = localMovieDataSource.getUpcomingMovies()

    override suspend fun getTopRatedMoviesLocal(): MovieList = localMovieDataSource.getTopRatedMovies()

    override suspend fun getPopularMoviesLocal(): MovieList = localMovieDataSource.getPopularMovies()

    override suspend fun saveMovie(movie: MovieEntity) = localMovieDataSource.saveMovie(movie)

    override suspend fun saveAllMovie(movieList: List<MovieEntity>) = localMovieDataSource.saveAllMovie(movieList)


}