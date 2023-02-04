package com.jmarcelo.moviesapp.fragmentoviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jmarcelo.moviesapp.R
import com.jmarcelo.moviesapp.databinding.FragmentOneBinding


class FragmentOne : Fragment() {

    private lateinit var binding:FragmentOneBinding
    //atacha el viewmodel al activity para que todos los fragmentos puedan accerder al estado
    private val viewModel: FragmentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = "Hola perros"
        viewModel.setUsuario(binding.text.text.toString())

        binding.text.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo)
        }

       findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("atras")
            ?.observe(viewLifecycleOwner){
               binding.text.text = it
            }
    }

}