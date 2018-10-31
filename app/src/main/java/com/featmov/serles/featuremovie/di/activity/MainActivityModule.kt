package com.featmov.serles.featuremovie.di.activity

import com.featmov.serles.featuremovie.presentation.FragmentMain
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    internal abstract fun mainFragmentInjector() : FragmentMain
}