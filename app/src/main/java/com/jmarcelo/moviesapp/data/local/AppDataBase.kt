package com.jmarcelo.moviesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity

@Database(entities = [MovieEntity::class], version = 2)
abstract class AppDataBase: RoomDatabase() {
    abstract fun movieDao():MovieDao
}