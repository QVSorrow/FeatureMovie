package com.featmov.serles.featuremovie.presentation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.featmov.serles.featuremovie.data.remote.responce.MovieItem
import com.featmov.serles.featuremovie.repositories.main.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieViewModel
constructor(val repository: MovieRepository): ViewModel() {
    val movieLiveData = MutableLiveData<List<MovieItem>>()


    fun getMovie(){
        GlobalScope.launch(Dispatchers.IO) {
            repository.getMovie("cf2974e3ef572c9c56435120e1df172f")
            getMovieFromDB()
        }
    }

    fun getMovieFromDB(){
        GlobalScope.launch(Dispatchers.IO) {
            val rez = repository.getMovieFromDB(/*550*/)
            movieLiveData.postValue(rez)
        }
    }
}