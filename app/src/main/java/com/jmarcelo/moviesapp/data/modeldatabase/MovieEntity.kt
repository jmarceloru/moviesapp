package com.jmarcelo.moviesapp.data.modeldatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.jmarcelo.moviesapp.data.model.Movie
import com.jmarcelo.moviesapp.data.model.MovieList

@Entity(tableName = "movieentity",primaryKeys = ["id", "movie_type" ])
data class MovieEntity(
    @ColumnInfo(name = "id") val id: Int = -1,
    @ColumnInfo(name = "adult") val adult: Boolean = false,
    // @ColumnInfo(name = "genere_ids") val genere_ids: List<Int>,
    @ColumnInfo(name = "backdrop_path") val backdrop_path: String? = "",
    @ColumnInfo(name = "original_title") val original_title: String = "",
    @ColumnInfo(name = "original_language") val original_language: String = "",
    @ColumnInfo(name = "overview") val overview: String = "",
    @ColumnInfo(name = "popularity") val popularity: Double = -1.0,
    @ColumnInfo(name = "poster_path") val poster_path: String = "",
    @ColumnInfo(name = "release_date") val release_date: String = "",
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "video") val video: Boolean = false,
    @ColumnInfo(name = "vote_average") val vote_average: Double = -1.0,
    @ColumnInfo(name = "vote_count") val vote_count: Int = -1,
    @ColumnInfo(name = "movie_type") val movie_type: String = ""
)

fun MovieEntity.toMovie(): Movie = Movie(
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
    this.movie_type
)

fun List<MovieEntity>.toMovieList(): MovieList {
    val resultList = mutableListOf<Movie>()
    this.forEach {
        resultList.add(it.toMovie())
    }
    return MovieList(resultList)
}
