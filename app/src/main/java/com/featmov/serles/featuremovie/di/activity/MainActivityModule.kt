package com.featmov.serles.featuremovie.di.activity

import com.featmov.serles.featuremovie.presentation.FragmentMain
import com.featmov.serles.featuremovie.presentation.FragmentSecond
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainFragmentInjector() : FragmentMain

    @ContributesAndroidInjector
    internal abstract fun secondFragmentInjection() : FragmentSecond
}