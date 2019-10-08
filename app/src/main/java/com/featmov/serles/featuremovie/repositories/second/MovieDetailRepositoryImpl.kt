package com.featmov.serles.featuremovie.repositories.second

import com.featmov.serles.featuremovie.*
import com.featmov.serles.featuremovie.data.database.FeatureMovieDataBase
import com.featmov.serles.featuremovie.data.remote.RemoteDataSource
import com.featmov.serles.featuremovie.data.remote.responce.MovieDetails

class MovieDetailRepositoryImpl
constructor(val remoteDataSource: RemoteDataSource, val db : FeatureMovieDataBase): MovieDetailRepository {

    override suspend fun getMovie(api_key : String, id: Int): MovieDetails {
        val rez =  remoteDataSource.getMovie(id, api_key).await()
        db.movieDetailsDataDao().insertMovie(mapMovieToDB(rez),
                mapMovieGenresToDB(rez.genres?: arrayListOf(), rez.id),
                mapMovieProductionCompanies(rez.production_companies?: arrayListOf(), rez.id),
                mapMovieProductionCountries(rez.production_countries?: arrayListOf(), rez.id),
                mapMovieSpokenLanguages(rez.spoken_languages?: arrayListOf(), rez.id))
        return rez
    }

    override suspend fun getMovieFromDB(id : Int) : MovieDetails {
        val rez = db.movieDetailsDataDao().getMovieById(id)
        return mapMovieFromDB(rez.movie, rez.genres, rez.productionCompanies, rez.productionCountries, rez.spokenLanguages)
    }
}