package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.presentation.main.viewmodel.MovieViewModel
import com.featmov.serles.featuremovie.presentation.second.viewmodel.MovieDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}