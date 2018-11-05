package com.featmov.serles.featuremovie.presentation

import com.featmov.serles.featuremovie.data.remote.responce.Movie
import kotlinx.coroutines.Deferred

interface MovieRepository {

    suspend fun getMovie(api_key : String)

    suspend fun getMovieFromDB(id: Int): Movie
}