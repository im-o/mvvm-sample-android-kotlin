package com.stimednp.kotlinsamplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stimednp.kotlinsamplemvvm.model.MovieList
import com.stimednp.kotlinsamplemvvm.model.MovieResponse
import com.stimednp.kotlinsamplemvvm.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rivaldy on Aug/09/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieViewModel: ViewModel() {
    private val listMovie = MutableLiveData<MutableList<MovieList>>()

    fun getMovies(): LiveData<MutableList<MovieList>> {
        loadMovies()
        return listMovie
    }

    private fun loadMovies() {
        val repository = MovieRepository().getMovies()
        GlobalScope.launch(Dispatchers.Main) {
            repository.enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful){
                        val movieList = response.body()?.results ?: return
                        listMovie.postValue(movieList)
                    }
                }
            })
        }
    }
}