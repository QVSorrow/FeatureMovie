package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.repositories.main.MovieRepository
import com.featmov.serles.featuremovie.repositories.main.MovieRepositoryImpl
import com.featmov.serles.featuremovie.repositories.second.MovieDetailRepository
import com.featmov.serles.featuremovie.repositories.second.MovieDetailRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<MovieDetailRepository> { MovieDetailRepositoryImpl(get(), get()) }
}