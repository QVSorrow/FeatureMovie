package com.featmov.serles.featuremovie.data.database.entitis

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity(tableName = "movieDetailsData")
data class MovieDetailsEntity (
        @PrimaryKey(autoGenerate = false) var id: Int,
        var adult: Boolean,
        var backdropPath: String,
        var budget: Long,
        var homepage: String,
        var imdbId: String,
        var originalLanguage: String,
        var originalTitle: String,
        var overview: String,
        var popularity: Float,
        var posterPath: String,
        var releaseDate: String,
        var revenue: Long,
        var runtime: Int,
        var status: String,
        var tagline: String,
        var title: String,
        var video: Boolean,
        var voteAverage: Float,
        var voteCount: Int
)

@Entity(tableName = "genresData")
data class GenresEntity (
        @PrimaryKey(autoGenerate = false) var id: Int,
        var name: String,
        var movieId: Int
)

@Entity(tableName = "productionCompaniesData")
data class ProductionCompaniesEntity (
        @PrimaryKey(autoGenerate = false) var id: Int,
        var logoPath: String? = "",
        var name: String,
        var originCountry: String,
        var movieId: Int
)

@Entity(tableName = "productionCountriesData")
data class ProductionCountriesEntity (
        @PrimaryKey(autoGenerate = false) var iso_3166_1: String,
        var name: String,
        var movieId: Int
)

@Entity(tableName = "spokenLanguagesData")
data class SpokenLanguagesEntity (
        @PrimaryKey(autoGenerate = false) var iso_639_1: String,
        var name: String,
        var movieId: Int
)

class MovieDetailsData {
    @Embedded
    lateinit var movie : MovieDetailsEntity
    @Relation(parentColumn = "id", entityColumn = "movieId", entity = GenresEntity::class)
    lateinit var genres : List<GenresEntity>
    @Relation(parentColumn = "id", entityColumn = "movieId", entity = ProductionCompaniesEntity::class)
    lateinit var productionCompanies : List<ProductionCompaniesEntity>
    @Relation(parentColumn = "id", entityColumn = "movieId", entity = ProductionCountriesEntity::class)
    lateinit var productionCountries : List<ProductionCountriesEntity>
    @Relation(parentColumn = "id", entityColumn = "movieId", entity = SpokenLanguagesEntity::class)
    lateinit var spokenLanguages : List<SpokenLanguagesEntity>
}