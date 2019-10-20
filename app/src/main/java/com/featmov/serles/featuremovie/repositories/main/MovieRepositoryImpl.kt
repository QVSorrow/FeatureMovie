package com.featmov.serles.featuremovie.repositories.main

import com.featmov.serles.featuremovie.*
import com.featmov.serles.featuremovie.data.database.FeatureMovieDataBase
import com.featmov.serles.featuremovie.data.remote.RemoteDataSource
import com.featmov.serles.featuremovie.data.remote.responce.MovieItem

class MovieRepositoryImpl
constructor(val remoteDataSource: RemoteDataSource, val db : FeatureMovieDataBase): MovieRepository {

    override suspend fun getMovie(api_key : String){
        val rez =  remoteDataSource.getAllMovies(api_key, 1).await()
        db.movieListDataDao().insertMovie(mapAllMoviesToDB(rez.results))
    }

    override suspend fun getMovieFromDB() : List<MovieItem> {
        val rez = db.movieListDataDao().getMovie()
        return mapAllMoviesFromDB(rez)
    }
}