package com.stimednp.kotlinsamplemvvm.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stimednp.kotlinsamplemvvm.databinding.ItemMovieBinding
import com.stimednp.kotlinsamplemvvm.model.MovieList

/**
 * Created by rivaldy on Aug/10/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieAdapter(private val movieList: MutableList<MovieList>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bindItem(movieList[position])
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(movieList: MovieList) {
            val strUrlImg = "https://image.tmdb.org/t/p/w220_and_h330_face${movieList.posterPath}"
            val strTitle = movieList.originalTitle
            val strDesc = movieList.overview
            val strVote = movieList.voteAverage.toString()

            Log.e("INIIII","INIIII -> $strTitle\n$strTitle\n$strVote")
            binding.apply {
                tvTitle.text = strTitle
                tvOverview.text = strDesc
                tvVote.text = strVote
                Picasso.get()
                    .load(strUrlImg)
                    .into(imgPoster)
            }
        }
    }
}