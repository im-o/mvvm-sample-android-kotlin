package com.stimednp.kotlinsamplemvvm.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

@Serializable
data class MovieResponse(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: MutableList<MovieList>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null
)