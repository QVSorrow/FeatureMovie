package com.featmov.serles.featuremovie.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.featmov.serles.featuremovie.data.database.entitis.*

@Dao
interface MovieDataDao {

    @Query("SELECT * from movieData where id = :id")
    fun getMovieById(id: Int): MovieData

    @Query("DELETE from movieData where id = :id")
    fun deleteMovieById(id : Int)

    @Insert(onConflict = REPLACE)
    fun insertMovie(movie : MovieEntity)

    @Insert(onConflict = REPLACE)
    fun insertMovieGenres(genresEntity : GenresEntity)

    @Insert(onConflict = REPLACE)
    fun insertMovieProductionCompanies(productionCompaniesEntity : ProductionCompaniesEntity)

    @Insert(onConflict = REPLACE)
    fun insertMovieProductionCountries(productionCountriesEntity : ProductionCountriesEntity)

    @Insert(onConflict = REPLACE)
    fun insertMovieSpokenLanguages(spokenLanguagesEntity : SpokenLanguagesEntity)
}