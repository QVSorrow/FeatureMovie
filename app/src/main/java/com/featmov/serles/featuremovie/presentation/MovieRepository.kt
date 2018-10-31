package com.featmov.serles.featuremovie.presentation

import com.featmov.serles.featuremovie.data.Movie
import io.reactivex.Single

interface MovieRepository {

    fun getMovie(api_key : String): Single<Movie>
}