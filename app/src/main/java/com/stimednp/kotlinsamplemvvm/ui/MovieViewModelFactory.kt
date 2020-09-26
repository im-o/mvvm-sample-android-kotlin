package com.stimednp.kotlinsamplemvvm.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stimednp.kotlinsamplemvvm.repository.MovieRepository

/**
 * Created by rivaldy on Sep/26/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieViewModelFactory(
    private val repository: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            val constructor = modelClass.getDeclaredConstructor(MovieRepository::class.java)
            return constructor.newInstance(repository)
        } catch (err: Exception) {
            Log.e("ERROR INI", "INI -> $err")
        }
        return super.create(modelClass)
    }
}