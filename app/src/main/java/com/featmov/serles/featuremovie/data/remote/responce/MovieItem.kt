package com.featmov.serles.featuremovie.data.remote.responce

data class MoviesResponse (
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<MovieItem>
)

data class MovieItem (
        val vote_count: Long,
        val id: Int,
        val video: Boolean,
        val vote_average: Float,
        val title: String? = "",
        val popularity: Float,
        val poster_path: String? = "",
        val original_language: String? = "",
        val original_title: String? = "",
        val genre_ids: ArrayList<Int>,
        val backdrop_path: String? = "",
        val adult: Boolean,
        val overview: String? = "",
        val release_date: String? = ""
)

