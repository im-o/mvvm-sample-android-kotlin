package com.stimednp.kotlinsamplemvvm.repository

import com.stimednp.kotlinsamplemvvm.BuildConfig
import com.stimednp.kotlinsamplemvvm.model.MovieResponse
import com.stimednp.kotlinsamplemvvm.network.ApiClient
import retrofit2.Call

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieRepository {
    fun getMovies(): Call<MovieResponse>{
        val apiService = ApiClient().getMovieApiService()
        return apiService.getMovieList(BuildConfig.API_KEY,"en-US")
    }
}