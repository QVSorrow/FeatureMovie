package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.presentation.MovieRepository
import com.featmov.serles.featuremovie.presentation.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Singleton
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(movieRepository : MovieRepositoryImpl) : MovieRepository
}