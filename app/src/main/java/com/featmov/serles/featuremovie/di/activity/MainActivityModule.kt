package com.featmov.serles.featuremovie.di.activity

import com.featmov.serles.featuremovie.presentation.main.fragment.FragmentMain
import com.featmov.serles.featuremovie.presentation.second.fragment.FragmentSecond
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainFragmentInjector() : FragmentMain

    @ContributesAndroidInjector
    internal abstract fun secondFragmentInjection() : FragmentSecond
}