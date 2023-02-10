package com.jmarcelo.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.data.local.AppDataBase
import com.jmarcelo.moviesapp.repository.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "appdatabase"
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideMovieDao(dataBase: AppDataBase) = dataBase.movieDao()

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)

}