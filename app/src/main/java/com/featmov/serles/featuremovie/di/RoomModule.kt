package com.featmov.serles.featuremovie.di

import android.content.Context
import com.featmov.serles.featuremovie.data.database.FeatureMovieDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideUserMapper(context: Context): FeatureMovieDataBase {
        return FeatureMovieDataBase.getAppDataBase(context)!!
    }
}