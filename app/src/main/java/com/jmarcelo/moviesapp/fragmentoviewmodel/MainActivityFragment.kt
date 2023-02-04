package com.jmarcelo.moviesapp.fragmentoviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jmarcelo.moviesapp.databinding.ActivityMainFragmentBinding

class MainActivityFragment : AppCompatActivity() {

    private lateinit var binding: ActivityMainFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}