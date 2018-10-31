package com.featmov.serles.featuremovie.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.featmov.serles.featuremovie.data.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieViewModel
@Inject
constructor(val repository: MovieRepository): ViewModel() {
    val movieLiveData = MutableLiveData<Movie>()
    private val disposable: CompositeDisposable = CompositeDisposable()


    fun getMovie(){
        disposable.add(repository.getMovie("cf2974e3ef572c9c56435120e1df172f")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  movieLiveData.postValue(it)
                }, {

                })
        )
    }
}