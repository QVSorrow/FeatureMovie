package com.featmov.serles.featuremovie.data.remote

import com.featmov.serles.featuremovie.data.remote.responce.Movie
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("movie/550")
    fun getMovie(
            @Query("api_key") api_key: String
    ) : Deferred<Movie>
}