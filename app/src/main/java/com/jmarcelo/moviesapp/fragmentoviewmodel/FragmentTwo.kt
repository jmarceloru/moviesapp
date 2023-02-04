package com.jmarcelo.moviesapp.fragmentoviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jmarcelo.moviesapp.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private val viewModel: FragmentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userLive.observe(viewLifecycleOwner){
            binding.text.text = it
        }

        findNavController().previousBackStackEntry?.savedStateHandle?.set("atras","Im back")

    }




}