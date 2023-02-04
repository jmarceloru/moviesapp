package com.jmarcelo.moviesapp.fragmentoviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentsViewModel : ViewModel() {

    private val user= MutableLiveData<String>()
    val userLive : LiveData<String> get() = user

    fun setUsuario(texto: String){
        user.value = texto
    }

}