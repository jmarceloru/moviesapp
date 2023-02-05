package com.jmarcelo.moviesapp.usecase

import com.jmarcelo.moviesapp.data.model.MovieListModel
import com.jmarcelo.moviesapp.data.model.toMovieEntity
import com.jmarcelo.moviesapp.repository.MovieRepositoryImpl

class GetMoviesUseCase(
    private val movieRepositoryImpl: MovieRepositoryImpl,
) {

    suspend fun getUpcommingMovies(): MovieListModel {
        var movieListModel = MovieListModel()
        movieRepositoryImpl.getUpcomingMovies().onSuccess {
            it.results.forEach { movie ->
                movieRepositoryImpl.saveMovie(movie.toMovieEntity("upcomming"))
            }
            movieListModel = MovieListModel(
                it.results,
                "Cargado de internet"
            )
        }.onFailure {
            movieListModel = MovieListModel(movieRepositoryImpl.getUpcomingMoviesLocal().results,"Cargado de Room")
        }
        return movieListModel
    }

    suspend fun getTopRatedMovies(): MovieListModel {
        var movieListModel = MovieListModel()
        movieRepositoryImpl.getTopRatedMovies().onSuccess {
            it.results.forEach { movie ->
                movieRepositoryImpl.saveMovie(movie.toMovieEntity("toprated"))
            }
            movieListModel = MovieListModel(
                it.results,
                "Cargado de internet"
            )
        }.onFailure {
            movieListModel = MovieListModel(movieRepositoryImpl.getTopRatedMoviesLocal().results,"Cargado de Room")
        }
        return movieListModel
    }

    suspend fun getPopularMovies(): MovieListModel {
        var movieListModel = MovieListModel()
        movieRepositoryImpl.getPopularMovies().onSuccess {
            it.results.forEach { movie ->
                movieRepositoryImpl.saveMovie(movie.toMovieEntity("popular"))
            }
            movieListModel = MovieListModel(
                it.results,
                "Cargado de internet"
            )
        }.onFailure {
            movieListModel = MovieListModel(movieRepositoryImpl.getPopularMoviesLocal().results,"Cargado de Room")
        }
        return movieListModel
    }

}