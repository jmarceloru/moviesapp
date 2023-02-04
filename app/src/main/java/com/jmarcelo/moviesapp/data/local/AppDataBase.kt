package com.jmarcelo.moviesapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jmarcelo.moviesapp.data.modeldatabase.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun movieDao():MovieDao

    companion object{
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "appdatabase"
            ).build()

            return INSTANCE!!
        }

        fun destroyDatabase(){
            INSTANCE = null
        }
    }
}