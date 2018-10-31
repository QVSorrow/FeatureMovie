package com.featmov.serles.featuremovie.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("movie/550")
    fun getMovie(
            @Query("api_key") api_key: String
    ) : Single<Movie>
}