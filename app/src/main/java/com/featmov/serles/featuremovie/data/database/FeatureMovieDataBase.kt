package com.featmov.serles.featuremovie.data.database

import android.arch.persistence.room.*
import android.content.Context
import com.featmov.serles.featuremovie.data.database.dao.MovieDataDao
import com.featmov.serles.featuremovie.data.database.dao.MovieDetailsDataDao
import com.featmov.serles.featuremovie.data.database.entitis.*

@Database(entities = arrayOf(MovieDetailsEntity::class, GenresEntity::class,
        ProductionCompaniesEntity::class, ProductionCountriesEntity::class, SpokenLanguagesEntity::class, MovieEntity::class), version = 1, exportSchema = false)
abstract class FeatureMovieDataBase : RoomDatabase(){
    abstract fun movieDetailsDataDao(): MovieDetailsDataDao
    abstract fun movieListDataDao(): MovieDataDao

    companion object {
        var INSTANCE : FeatureMovieDataBase? = null

        fun getAppDataBase(context: Context): FeatureMovieDataBase? {
            if (INSTANCE == null){
                synchronized(FeatureMovieDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, FeatureMovieDataBase::class.java, "FeatureMovieDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}