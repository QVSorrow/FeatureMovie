package com.featmov.serles.featuremovie.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
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