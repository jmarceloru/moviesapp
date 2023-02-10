package com.jmarcelo.moviesapp.data.local

import androidx.room.*
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * from movieentity")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // en caso de conflicto reemplaza el registro
    suspend fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovie(movisList: List<MovieEntity>)

    @Delete
    suspend fun deleteMovie(movisList: MovieEntity)

    @Query("DELETE FROM movieentity where id = :id and movie_type = :type")
    suspend fun deleteMovieByIdAndType(id:Int,type:String)

}