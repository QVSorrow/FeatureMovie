package com.featmov.serles.featuremovie.di

import android.content.Context
import com.featmov.serles.featuremovie.data.database.FeatureMovieDataBase
import org.koin.dsl.module

val roomModule = module {

    fun provideUserMapper(context: Context): FeatureMovieDataBase {
        return FeatureMovieDataBase.getAppDataBase(context)!!
    }

    single { provideUserMapper(get()) }
}