package com.engie.eea_tech_interview.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.engie.eea_tech_interview.business.domain.model.Movie

class MainComparator : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem == newItem
}