package com.stimednp.kotlinsamplemvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stimednp.kotlinsamplemvvm.BuildConfig
import com.stimednp.kotlinsamplemvvm.model.MovieList
import com.stimednp.kotlinsamplemvvm.model.MovieResponse
import com.stimednp.kotlinsamplemvvm.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val listMovie = MutableLiveData<MutableList<MovieList>>()
    fun getMovies(): LiveData<MutableList<MovieList>> {
        loadMovies()
        return listMovie
    }

    private fun loadMovies() {
        repository.getMoviesList(BuildConfig.API_KEY, "en-US").enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {}

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movieList = response.body()?.results ?: return
                    listMovie.postValue(movieList)
                }
            }
        })
    }
}