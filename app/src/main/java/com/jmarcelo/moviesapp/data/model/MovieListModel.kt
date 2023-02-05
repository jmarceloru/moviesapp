package com.jmarcelo.moviesapp.data.model

data class MovieListModel(
    val results: List<Movie> = listOf(),
    val message: String = ""
)