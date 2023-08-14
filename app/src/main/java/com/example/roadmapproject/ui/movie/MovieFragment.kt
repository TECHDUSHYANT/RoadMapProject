package com.example.roadmapproject.ui.movie

import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.roadmapproject.R
import com.example.roadmapproject.databinding.FragmentMovieBinding
import com.example.roadmapproject.ui.movie.adapter.MovieAdapter
import com.example.roadmapproject.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private val movieViewModel : MovieViewModel by viewModels()

    @Inject
    lateinit var movieAdapter : MovieAdapter
    private  var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie, container, false
        )
        binding.viewModel = movieViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = movieAdapter

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        movieViewModel.movieResponse.observe(viewLifecycleOwner) {
            when(it) {
                is NetworkResult.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }

                is NetworkResult.Failure -> {
                    binding.progressCircular.visibility = View.GONE
                }

                is  NetworkResult.Success -> {
                    movieAdapter.setContentList(it.data)
                    binding.progressCircular.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        _binding = null
    }

}