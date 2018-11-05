package com.featmov.serles.featuremovie

import com.featmov.serles.featuremovie.data.database.entitis.*
import com.featmov.serles.featuremovie.data.remote.responce.*

fun mapMovieToDB(movie: Movie) : MovieEntity{
    return MovieEntity(movie.id, movie.adult, movie.backdrop_path, movie.budget, /*movie.genres.map { GenresEntity(it.id, it.name, movie.id) },*/ movie.homepage,
            movie.imdb_id, movie.original_language, movie.original_title, movie.overview, movie.popularity,
            movie.poster_path, /*movie.production_companies.map { ProductionCompaniesEntity(it.id, it.logo_path, it.name, it.origin_country, movie.id) },*/
            /*movie.production_countries.map { ProductionCountriesEntity(it.iso_3166_1, it.name, movie.id) },*/ movie.release_date, movie.revenue, movie.runtime,
            /*movie.spoken_languages.map { SpokenLanguagesEntity(it.iso_639_1, it.name, movie.id) },*/ movie.status, movie.tagline, movie.title, movie.video,
            movie.vote_average, movie.vote_count)
}

fun mapMovieGenresToDB(movieGenres: Genres, movieId: Int) : GenresEntity {
    return GenresEntity(movieGenres.id, movieGenres.name, movieId)
}

fun mapMovieProductionCompanies(productionCompanies: ProductionCompanies, movieId : Int) : ProductionCompaniesEntity {
    return ProductionCompaniesEntity(productionCompanies.id, productionCompanies.logo_path, productionCompanies.name, productionCompanies.origin_country, movieId)
}

fun mapMovieProductionCountries(productionCountries: ProductionCountries, movieId : Int) : ProductionCountriesEntity {
    return ProductionCountriesEntity(productionCountries.iso_3166_1, productionCountries.name, movieId)
}

fun mapMovieSpokenLanguages(spokenLanguages: SpokenLanguages, movieId : Int) : SpokenLanguagesEntity {
    return SpokenLanguagesEntity(spokenLanguages.iso_639_1, spokenLanguages.name, movieId)
}

fun mapMovieFromDB(movieEntity : MovieEntity, genres : List<GenresEntity>, productionCompanies : List<ProductionCompaniesEntity>,
                   productionCountries : List<ProductionCountriesEntity>, spokenLanguages : List<SpokenLanguagesEntity>) : Movie {
    return Movie(movieEntity.adult, movieEntity.backdropPath, movieEntity.budget, mapMovieGenresFromDB(genres), movieEntity.homepage,
            movieEntity.id, movieEntity.imdbId, movieEntity.originalLanguage, movieEntity.originalTitle, movieEntity.overview,
            movieEntity.popularity, movieEntity.posterPath, mapMovieProductionCompaniesFromDB(productionCompanies), mapMovieProductionCountriesFromDB(productionCountries),
            movieEntity.releaseDate, movieEntity.revenue, movieEntity.runtime, mapMoviesspokenLanguagesFromDB(spokenLanguages), movieEntity.status,
            movieEntity.tagline, movieEntity.title, movieEntity.video, movieEntity.voteAverage, movieEntity.voteCount)
}

fun mapMovieGenresFromDB(genres : List<GenresEntity>) : List<Genres> {
    return genres.map { Genres(it.id, it.name) }
}

fun mapMovieProductionCompaniesFromDB(productionCompanies : List<ProductionCompaniesEntity>) : List<ProductionCompanies> {
    return productionCompanies.map { ProductionCompanies(it.id, it.logoPath, it.name, it.originCountry) }
}

fun mapMovieProductionCountriesFromDB(productionCountries : List<ProductionCountriesEntity>) : List<ProductionCountries> {
    return productionCountries.map { ProductionCountries(it.iso_3166_1, it.name) }
}

fun mapMoviesspokenLanguagesFromDB(spokenLanguages : List<SpokenLanguagesEntity>) : List<SpokenLanguages> {
    return spokenLanguages.map { SpokenLanguages(it.iso_639_1, it.name) }
}
