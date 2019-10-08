package com.featmov.serles.featuremovie

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.featmov.serles.featuremovie.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule,
                    repositoryModule,
                    roomModule,
                    remoteModule))
        }
    }
}