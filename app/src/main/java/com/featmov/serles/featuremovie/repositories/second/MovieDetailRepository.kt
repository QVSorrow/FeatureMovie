package com.featmov.serles.featuremovie.repositories.second

import com.featmov.serles.featuremovie.data.remote.responce.MovieDetails

interface MovieDetailRepository {
    suspend fun getMovie(api_key : String, id: Int): MovieDetails

    suspend fun getMovieFromDB(id: Int): MovieDetails
}