package com.jmarcelo.moviesapp.data.model

import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity

data class Movie(
    val id: Int = -1,
    val adult: Boolean = false,
    //val genere_ids: List<Int> = listOf(),
    val backdrop_path: String? = "",
    val original_title: String = "",
    val original_language: String ="",
    val overview:String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movie_type: String = ""
)

fun Movie.toMovieEntity(movie_type: String) = MovieEntity(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type = movie_type
)


