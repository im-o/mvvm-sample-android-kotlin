package com.stimednp.kotlinsamplemvvm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

data class MovieResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: MutableList<MovieList>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)