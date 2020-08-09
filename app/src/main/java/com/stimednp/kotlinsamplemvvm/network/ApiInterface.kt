package com.stimednp.kotlinsamplemvvm.network

import com.stimednp.kotlinsamplemvvm.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface ApiInterface {
    @GET("discover/movie") //discover/movie?api_key={your api key}&language={language}
    fun getMovieList(@Query("api_key") apiKey: String, @Query("language") strLanguage: String) : Call<MovieResponse>
}