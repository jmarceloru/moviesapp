package com.jmarcelo.moviesapp.ui.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.core.BaseViewHolder
import com.jmarcelo.moviesapp.data.model.Movie
import com.jmarcelo.moviesapp.databinding.MovieItemBinding

class MovieAdapter(
    private val movieList: List<Movie>,
    private val itemClickListener: OnMovieClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val holder = MoviesViewHolder(itemBinding,parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it!= DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener

            itemClickListener.onMovieClick(movieList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){
           is MoviesViewHolder -> holder.bind(movieList[position])
       }
    }

    override fun getItemCount(): Int = movieList.size

    private inner class MoviesViewHolder(
        private val binding: MovieItemBinding,
        private val context: Context
    ) : BaseViewHolder<Movie>(binding.root) {
        override fun bind(item: Movie) {
            Glide.with(context)
                .load(AppConstants.BASE_URL_IMAGE+item.poster_path)
                .centerCrop()
                .into(binding.imgMovie)
        }

    }
}