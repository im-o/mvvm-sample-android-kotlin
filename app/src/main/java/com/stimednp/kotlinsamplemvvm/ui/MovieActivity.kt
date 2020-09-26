package com.stimednp.kotlinsamplemvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.kotlinsamplemvvm.databinding.ActivityMovieBinding
import com.stimednp.kotlinsamplemvvm.model.MovieList
import com.stimednp.kotlinsamplemvvm.utils.gone
import com.stimednp.kotlinsamplemvvm.utils.visible
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MovieActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: MovieViewModelFactory by instance()
    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
    }

    private fun initViewModel() {
        binding.loadingPB.visible()
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        viewModel.getMovies().observe(this, Observer {
            binding.loadingPB.gone()
            setupAdapter(it ?: return@Observer)
        })
    }

    private fun setupAdapter(listMovies: MutableList<MovieList>) {
        val movieAdapter = MovieAdapter(listMovies)
        binding.movieRV.apply {
            layoutManager = LinearLayoutManager(this@MovieActivity)
            adapter = movieAdapter
        }
    }

}
