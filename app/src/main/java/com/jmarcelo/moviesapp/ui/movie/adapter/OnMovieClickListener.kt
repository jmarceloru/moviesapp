package com.jmarcelo.moviesapp.ui.movie.adapter

import com.jmarcelo.moviesapp.data.model.Movie

interface OnMovieClickListener {
    fun onMovieClick(movie:Movie)
}