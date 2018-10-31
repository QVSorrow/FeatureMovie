package com.featmov.serles.featuremovie.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: Application) {

    @Provides
    fun bindContext(): Context = app

}