package com.featmov.serles.featuremovie.presentation.main.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.featmov.serles.featuremovie.base.BaseViewModel
import com.featmov.serles.featuremovie.data.remote.responce.MovieItem
import com.featmov.serles.featuremovie.repositories.main.MovieRepository
import kotlinx.coroutines.*

class MovieViewModel
constructor(val repository: MovieRepository): BaseViewModel() {
    //val movieLiveData = MutableLiveData<List<MovieItem>>()
    val data = ObservableField<List<MovieItem>>()

    init {
        getMovie()
    }

    fun getMovie() {
        uiScope.launch {
            repository.getMovie("cf2974e3ef572c9c56435120e1df172f")
            getMovieFromDB()
        }
    }

    private fun getMovieFromDB() {
        viewModelScope
        uiScope.launch {
            val rez = repository.getMovieFromDB(/*550*/)
            //movieLiveData.postValue(rez)
            data.set(rez)
        }
    }
}