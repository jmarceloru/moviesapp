package com.jmarcelo.moviesapp.ui.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jmarcelo.moviesapp.commons.AppConstants
import com.jmarcelo.moviesapp.databinding.FragmentMovieImageScreenBinding


class MovieImageScreenFragment : Fragment() {

    private lateinit var binding: FragmentMovieImageScreenBinding
    private val args by navArgs<MovieImageScreenFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieImageScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.hide()
        Glide.with(requireContext())
            .load(AppConstants.BASE_URL_POSTER_PATH+args.posterPathUrl)
            .into(binding.imgMovie)
    }

}