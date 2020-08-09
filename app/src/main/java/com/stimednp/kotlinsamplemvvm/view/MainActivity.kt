package com.stimednp.kotlinsamplemvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.kotlinsamplemvvm.databinding.ActivityMainBinding
import com.stimednp.kotlinsamplemvvm.model.MovieList
import com.stimednp.kotlinsamplemvvm.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewModel()
    }

    private fun initViewModel() {
        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        movieViewModel.getMovies().observe(this, Observer {
            setupAdapter(it ?: return@Observer)
        })
    }

    private fun setupAdapter(listMovies: MutableList<MovieList>) {
        val movieAdapter = MovieAdapter(listMovies)
        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }
}
