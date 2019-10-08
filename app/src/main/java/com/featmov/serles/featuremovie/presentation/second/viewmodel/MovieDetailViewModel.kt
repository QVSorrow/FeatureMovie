package com.featmov.serles.featuremovie.presentation.second.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.featmov.serles.featuremovie.data.remote.responce.MovieDetails
import com.featmov.serles.featuremovie.repositories.second.MovieDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MovieDetailViewModel
constructor(val repository: MovieDetailRepository): ViewModel(){
    val movieLiveData = MutableLiveData<MovieDetails>()

    fun getMovie(id: Int){
        GlobalScope.launch(Dispatchers.IO) {
            val detailId = repository.getMovie("cf2974e3ef572c9c56435120e1df172f", id)
            async(Dispatchers.IO) { getMovieFromDB(detailId.id) }.await()
        }
    }

    fun getMovieFromDB(id: Int){
        GlobalScope.launch(Dispatchers.IO) {
            val rez = repository.getMovieFromDB(id)
            movieLiveData.postValue(rez)
        }
    }
}