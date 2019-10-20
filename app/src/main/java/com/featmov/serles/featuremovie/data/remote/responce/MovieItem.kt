package com.featmov.serles.featuremovie.data.remote.responce


data class MoviesResponse (
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<MovieItem>
)

data class MovieItem (
        val vote_count: Long? = 0,
        val id: Int,
        val video: Boolean? = false,
        val vote_average: Float? = 0f,
        val title: String? = "",
        val popularity: Float? = 0f,
        val poster_path: String,
        val original_language: String? = "",
        val original_title: String? = "",
        val genre_ids: ArrayList<Int>? = arrayListOf(),
        val backdrop_path: String? = "",
        val adult: Boolean? = false,
        val overview: String? = "",
        val release_date: String? = ""
)
