package com.featmov.serles.featuremovie.data.database.entitis

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.Relation

@Entity(tableName = "movieData")
data class MovieEntity (
        @PrimaryKey(autoGenerate = false) var id: Int,
        val voteCount: Long,
        val video: Boolean,
        val voteAverage: Float,
        val title: String? = "",
        val popularity: Float,
        val posterPath: String? = "",
        val originalLanguage: String? = "",
        val originalTitle: String? = "",
        val backdropPath: String? = "",
        val adult: Boolean,
        val overview: String? = "",
        val releaseDate: String? = ""
)

@Entity(tableName = "movieGenreIdsData")
data class MovieGenreIdsEntity (
        @PrimaryKey(autoGenerate = false) var id: Int,
        var movieId: Int
)

class MovieData {
        @Embedded
        lateinit var movie : MovieEntity
        /*@Relation(parentColumn = "id", entityColumn = "movieId", entity = MovieGenreIdsEntity::class)
        lateinit var genres : List<MovieGenreIdsEntity>*/
}