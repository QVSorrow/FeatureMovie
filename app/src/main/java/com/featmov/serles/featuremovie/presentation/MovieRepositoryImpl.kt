package com.featmov.serles.featuremovie.presentation

import com.featmov.serles.featuremovie.data.RemoteDataSource
import javax.inject.Inject

class MovieRepositoryImpl
@Inject
constructor(val remoteDataSource: RemoteDataSource): MovieRepository {

    override fun getMovie(api_key : String) =  remoteDataSource.getMovie(api_key)
}