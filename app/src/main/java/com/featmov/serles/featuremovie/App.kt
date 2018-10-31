package com.featmov.serles.featuremovie

import android.support.v7.app.AppCompatDelegate
import com.featmov.serles.featuremovie.di.AppModule
import com.featmov.serles.featuremovie.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        //startKoin(this, listOf(movieModule))
    }

    override fun applicationInjector() : AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .create(this)
}