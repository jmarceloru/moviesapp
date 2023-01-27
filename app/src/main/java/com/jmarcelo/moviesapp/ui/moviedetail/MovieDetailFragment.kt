package com.jmarcelo.moviesapp.ui.moviedetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jmarcelo.moviesapp.R
import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext())
            .load(AppConstants.BASE_URL_POSTER_PATH+args.posterImageUrl)
            .centerCrop()
            .into(binding.imgMovie)
        Glide.with(requireContext())
            .load(AppConstants.BASE_URL_POSTER_PATH+args.backgroundImageUrl)
            .centerCrop()
            .into(binding.imgBackground)
        binding.txtMovieTitle.text = args.title
        binding.txtOverview.text = args.overview
        binding.txtLanguaje.text = "${getText(R.string.str_language)} ${args.language} "
        binding.txtRating.text ="${args.voteAverage}(${args.voteCount} ${getText(R.string.str_reviews)})"
        binding.txtRelease.text = "${args.releaseDate} ${getText(R.string.str_released)}"

        binding.imgMovie.setOnClickListener {
            val action = MovieDetailFragmentDirections.actionMovieDetailFragmentToMovieImageScreenFragment(
                args.posterImageUrl
            )
            findNavController().navigate(action)
        }

    }
}