package com.stimednp.kotlinsamplemvvm.repository

import com.stimednp.kotlinsamplemvvm.model.MovieResponse
import com.stimednp.kotlinsamplemvvm.network.ApiClient
import retrofit2.Call

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieRepository(
    private val apiClient: ApiClient
) {
    fun getMoviesList(apiKey: String, strLanguage: String): Call<MovieResponse>{
        return apiClient.apiTheMovie().getMovieList(apiKey, strLanguage)
    }
}