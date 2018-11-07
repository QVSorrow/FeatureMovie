package com.featmov.serles.featuremovie.repositories.main

import com.featmov.serles.featuremovie.data.remote.responce.MovieItem


interface MovieRepository {

    suspend fun getMovie(api_key : String)

    suspend fun getMovieFromDB(): List<MovieItem>
}