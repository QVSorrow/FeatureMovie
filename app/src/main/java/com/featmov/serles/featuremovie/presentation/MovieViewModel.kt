package com.featmov.serles.featuremovie.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.featmov.serles.featuremovie.data.database.FeatureMovieDataBase
import com.featmov.serles.featuremovie.data.remote.responce.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel
@Inject
constructor(val repository: MovieRepository): ViewModel() {
    val movieLiveData = MutableLiveData<Movie>()
    //private val disposable: CompositeDisposable = CompositeDisposable()


    fun getMovie(){
        GlobalScope.launch(Dispatchers.Default) {
            var rez = repository.getMovie("cf2974e3ef572c9c56435120e1df172f")
            getMovieFromDB()
            /*movieLiveData.postValue(rez)*/
        }
        /*disposable.add(repository.getMovie("cf2974e3ef572c9c56435120e1df172f")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  movieLiveData.postValue(it)
                }, {

                })
        )*/
    }

    fun getMovieFromDB(){
        GlobalScope.launch(Dispatchers.Default) {
            val rez = repository.getMovieFromDB(550)
            movieLiveData.postValue(rez)
        }
    }
}