package com.featmov.serles.featuremovie.data.database

import android.arch.persistence.room.*
import android.content.Context
import com.featmov.serles.featuremovie.data.database.entitis.*

@Database(entities = arrayOf(MovieEntity::class, GenresEntity::class,
        ProductionCompaniesEntity::class, ProductionCountriesEntity::class, SpokenLanguagesEntity::class), version = 1, exportSchema = false)
abstract class FeatureMovieDataBase : RoomDatabase(){
    abstract fun movieDataDao(): MovieDataDao

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