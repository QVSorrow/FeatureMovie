package com.featmov.serles.featuremovie

import com.featmov.serles.featuremovie.data.database.entitis.*
import com.featmov.serles.featuremovie.data.remote.responce.*

fun mapMovieToDB(movie: MovieDetails) : MovieDetailsEntity{
    return MovieDetailsEntity(movie.id, movie.adult?: false, movie.backdrop_path?: "", movie.budget?: 0, movie.homepage?: "",
            movie.imdb_id?: "", movie.original_language?: "", movie.original_title?: "", movie.overview?: "", movie.popularity?: 0f,
            movie.poster_path?: "", movie.release_date?: "", movie.revenue?: 0, movie.runtime?: 0, movie.status?: "", movie.tagline?: "",
            movie.title?: "", movie.video?: false, movie.vote_average?: 0f, movie.vote_count?: 0)
}

fun mapMovieGenresToDB(movieGenres: List<Genres>, movieId: Int) : List<GenresEntity> {
    return movieGenres.map { GenresEntity(it.id, it.name, movieId) }
}

fun mapMovieProductionCompanies(productionCompanies: List<ProductionCompanies>, movieId : Int) : List<ProductionCompaniesEntity> {
    return productionCompanies.map { ProductionCompaniesEntity(it.id, it.logo_path, it.name, it.origin_country, movieId) }
}

fun mapMovieProductionCountries(productionCountries: List<ProductionCountries>, movieId : Int) : List<ProductionCountriesEntity> {
    return productionCountries.map { ProductionCountriesEntity(it.iso_3166_1, it.name, movieId) }
}

fun mapMovieSpokenLanguages(spokenLanguages: List<SpokenLanguages>, movieId : Int) : List<SpokenLanguagesEntity> {
    return spokenLanguages.map { SpokenLanguagesEntity(it.iso_639_1, it.name, movieId) }
}

fun mapAllMoviesToDB(data : List<MovieItem>) : List<MovieEntity> {
    return data.map { MovieEntity(it.id, it.vote_count?: 0, it.video?: false, it.vote_average?: 0f, it.original_title,
            it.popularity?: 0f, it.poster_path, it.original_language, it.original_title, it.backdrop_path,
            it.adult?: false, it.overview, it.release_date) }
}

fun mapMovieFromDB(movieEntity : MovieDetailsEntity, genres : List<GenresEntity>, productionCompanies : List<ProductionCompaniesEntity>,
                   productionCountries : List<ProductionCountriesEntity>, spokenLanguages : List<SpokenLanguagesEntity>) : MovieDetails {
    return MovieDetails(movieEntity.adult, movieEntity.backdropPath, movieEntity.budget, mapMovieGenresFromDB(genres), movieEntity.homepage,
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

fun mapAllMoviesFromDB(data : List<MovieEntity>) : List<MovieItem> {
    return data.map { MovieItem(it.voteCount, it.id, it.video, it.voteAverage, it.originalTitle, it.popularity, it.posterPath?: "",
            it.originalLanguage, it.originalTitle, arrayListOf(), it.backdropPath, it.adult,
            it.overview, it.releaseDate) }
}
