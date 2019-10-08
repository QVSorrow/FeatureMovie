package com.featmov.serles.featuremovie.data.remote


import retrofit2.Retrofit

class RemoteDataSource
constructor(retrofit : Retrofit) : RemoteService {

    private val api = retrofit.create(RemoteService::class.java)

    override fun getMovie(id: Int, api_key : String) = api.getMovie(id, api_key)

    override fun getAllMovies(api_key : String, page : Int) = api.getAllMovies(api_key, page)
}