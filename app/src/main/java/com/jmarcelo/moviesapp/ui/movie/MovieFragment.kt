package com.jmarcelo.moviesapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.jmarcelo.moviesapp.core.Result
import com.jmarcelo.moviesapp.data.model.Movie
import com.jmarcelo.moviesapp.databinding.FragmentMovieBinding
import com.jmarcelo.moviesapp.presentation.MovieViewModel
import com.jmarcelo.moviesapp.ui.movie.adapter.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), OnMovieClickListener {

    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var binding: FragmentMovieBinding
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        concatAdapter = ConcatAdapter()

        movieViewModel.fetchMainScreenMovies().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("BUG", result.exception.toString())
                }
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    concatAdapter.apply {
                        addAdapter(
                            0,
                            UpcomingConcatAdapter(
                                MovieAdapter(
                                    result.data.first.results,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            1,
                            TopRatedConcatAdapter(
                                MovieAdapter(
                                    result.data.second.results,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            2,
                            PopularConcatAdapter(
                                MovieAdapter(
                                    result.data.third.results,
                                    this@MovieFragment
                                )
                            )
                        )
                    }
                    Log.d("ORIGEN",result.data.first.message)
                    binding.rvMovies.adapter = concatAdapter
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
            movie.poster_path,
            movie.backdrop_path,
            movie.vote_average.toFloat(),
            movie.vote_count,
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date
        )
        findNavController().navigate(action)
    }


}