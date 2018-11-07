package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.repositories.main.MovieRepository
import com.featmov.serles.featuremovie.repositories.main.MovieRepositoryImpl
import com.featmov.serles.featuremovie.repositories.second.MovieDetailRepository
import com.featmov.serles.featuremovie.repositories.second.MovieDetailRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Singleton
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(movieRepository : MovieRepositoryImpl) : MovieRepository

    @Binds
    abstract fun bindMovieDetailRepository(movieDetailRepository : MovieDetailRepositoryImpl) : MovieDetailRepository
}