package com.featmov.serles.featuremovie.data


import retrofit2.Retrofit
import javax.inject.Inject

class RemoteDataSource
@Inject
constructor(retrofit : Retrofit) : RemoteService {

    private val api = retrofit.create(RemoteService::class.java)

    override fun getMovie(api_key : String) = api.getMovie(api_key)
}