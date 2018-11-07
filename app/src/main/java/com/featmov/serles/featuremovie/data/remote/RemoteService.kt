package com.featmov.serles.featuremovie.data.remote

import com.featmov.serles.featuremovie.data.remote.responce.MovieDetails
import com.featmov.serles.featuremovie.data.remote.responce.MoviesResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteService {

    /**
     * Get movie detail info by id
     */
    @GET("movie/{id}")
    fun getMovie(
            @Path("id") id: Int,
            @Query("api_key") api_key: String
    ) : Deferred<MovieDetails>

    /**
     * Get list of all movies
     */
    @GET("discover/movie")
    fun getAllMovies(
            @Query("api_key") api_key: String,
            @Query("page") page: Int
    ) : Deferred<MoviesResponse>
}