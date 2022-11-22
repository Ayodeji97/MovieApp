package com.engie.eea_tech_interview.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.databinding.MovieListItemBinding

class MainAdapter(
    private val onMovieClicked: (Movie) -> Unit
) : ListAdapter<Movie, MainViewHolder>(MainComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val ui = MovieListItemBinding.inflate(layoutInflater, parent, false)
        return MainViewHolder(
            ui,
            onMovieClicked = { position ->
                val movie = getItem(position)
                onMovieClicked(movie)
            }
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentBinding = getItem(position)
        currentBinding.let {
            holder.bind(it)
        }
    }
}
