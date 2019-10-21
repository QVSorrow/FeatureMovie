package com.featmov.serles.featuremovie.presentation.second.viewmodel

import androidx.lifecycle.MutableLiveData
import com.featmov.serles.featuremovie.base.BaseViewModel
import com.featmov.serles.featuremovie.data.remote.responce.MovieDetails
import com.featmov.serles.featuremovie.repositories.second.MovieDetailRepository
import kotlinx.coroutines.*

class MovieDetailViewModel
constructor(val repository: MovieDetailRepository): BaseViewModel(){

    val movieLiveData = MutableLiveData<MovieDetails>()

    fun getMovie(id: Int){
        uiScope.launch {
            val detailId = repository.getMovie("cf2974e3ef572c9c56435120e1df172f", id)
            withContext(Dispatchers.Default) { getMovieFromDB(detailId.id) }
        }
    }

    private fun getMovieFromDB(id: Int){
        uiScope.launch {
            val rez = repository.getMovieFromDB(id)
            movieLiveData.postValue(rez)
        }
    }
}