package com.featmov.serles.featuremovie.presentation

import com.featmov.serles.featuremovie.*
import com.featmov.serles.featuremovie.data.database.FeatureMovieDataBase
import com.featmov.serles.featuremovie.data.remote.RemoteDataSource
import com.featmov.serles.featuremovie.data.remote.responce.Movie
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class MovieRepositoryImpl
@Inject
constructor(val remoteDataSource: RemoteDataSource, val db : FeatureMovieDataBase): MovieRepository {

    override suspend fun getMovie(api_key : String){
        val rez =  remoteDataSource.getMovie(api_key).await()
        db.movieDataDao().insertMovie(mapMovieToDB(rez))
        rez.genres.forEach {genres ->
            db.movieDataDao().insertMovieGenres(mapMovieGenresToDB(genres, rez.id))
        }
        rez.production_companies.forEach { production_companies ->
            db.movieDataDao().insertMovieProductionCompanies(mapMovieProductionCompanies(production_companies, rez.id))
        }
        rez.production_countries.forEach { production_countries ->
            db.movieDataDao().insertMovieProductionCountries(mapMovieProductionCountries(production_countries, rez.id))
        }
        rez.spoken_languages.forEach { spoken_languages ->
            db.movieDataDao().insertMovieSpokenLanguages(mapMovieSpokenLanguages(spoken_languages, rez.id))
        }
    }

    override suspend fun getMovieFromDB(id : Int) : Movie {
        val rez = db.movieDataDao().getMovieById(id)
        return mapMovieFromDB(rez.movie, rez.genres, rez.productionCompanies, rez.productionCountries, rez.spokenLanguages)
    }
}