package com.featmov.serles.featuremovie.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.featmov.serles.featuremovie.data.database.entitis.MovieEntity

@Dao
interface MovieDataDao {

    @Query("SELECT * from movieData")
    fun getMovie(): List<MovieEntity>

    @Query("DELETE from movieData")
    fun deleteMovie()

    @Insert(onConflict = REPLACE)
    fun insertMovie(movie : List<MovieEntity>)
}