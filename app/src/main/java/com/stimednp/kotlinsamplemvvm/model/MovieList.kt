package com.stimednp.kotlinsamplemvvm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

data class MovieList(
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null
)