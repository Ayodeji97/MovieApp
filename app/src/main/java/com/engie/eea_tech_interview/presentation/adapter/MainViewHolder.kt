package com.engie.eea_tech_interview.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.databinding.MovieListItemBinding
import com.engie.eea_tech_interview.presentation.utils.loadImage

class MainViewHolder(
    private val ui: MovieListItemBinding,
    private val onMovieClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(ui.root) {

    fun bind(movie: Movie) {
        ui.apply {
            movieTitleTv.text = movie.title
            movieAvatarIv.loadImage(movie.posterPath)
        }
    }

    init {
        ui.apply {
            root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onMovieClicked(position)
                }
            }
        }
    }
}
