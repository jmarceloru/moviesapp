package com.jmarcelo.moviesapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jmarcelo.moviesapp.core.Result
import com.jmarcelo.moviesapp.data.remote.MovieDataSource
import com.jmarcelo.moviesapp.databinding.FragmentMovieBinding
import com.jmarcelo.moviesapp.presentation.MovieViewModel
import com.jmarcelo.moviesapp.presentation.MovieViewModelFactory
import com.jmarcelo.moviesapp.repository.MovieRepositoryImpl
import com.jmarcelo.moviesapp.repository.RetrofitClient

class MovieFragment : Fragment() {

    private lateinit var binding:FragmentMovieBinding
    private val movieViewModel: MovieViewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(MovieRepositoryImpl(MovieDataSource(RetrofitClient.webService)))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.fetchMainScreenMovies().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Failure -> {
                    Log.d("LiveData", "${result.exception}")
                    binding.progressBar.visibility = View.GONE
                }
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("LiveData", "Loadinggg ...")
                }
                is Result.Success -> {
                    Log.d("LiveData", "${result.data.first}")
                    Log.d("LiveData", "${result.data.second}")
                    Log.d("LiveData", "${result.data.third}")
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }




}