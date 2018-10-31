package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.presentation.MainActivity
import com.featmov.serles.featuremovie.di.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mainInjection(): MainActivity
}