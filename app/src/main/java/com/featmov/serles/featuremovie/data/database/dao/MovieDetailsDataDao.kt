package com.featmov.serles.featuremovie.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.featmov.serles.featuremovie.data.database.entitis.*

@Dao
interface MovieDetailsDataDao {

    @Transaction
    @Query("SELECT * from movieDetailsData where id = :id")
    fun getMovieById(id: Int): MovieDetailsData

    @Query("DELETE from movieDetailsData where id = :id")
    fun deleteMovieById(id : Int)

    @Insert(onConflict = REPLACE)
    fun insertMovie(movie : MovieDetailsEntity,
                    genresEntity : List<GenresEntity>,
                    productionCompaniesEntity : List<ProductionCompaniesEntity>,
                    productionCountriesEntity : List<ProductionCountriesEntity>,
                    spokenLanguagesEntity : List<SpokenLanguagesEntity>)
}