package com.jmarcelo.moviesapp.commons

import android.annotation.SuppressLint
import java.util.*

object SettingsUtils {
    @SuppressLint("ConstantLocale")
    val LANGUAGE: String = when(Locale.getDefault().language){
        "en"-> "en-US"
        else -> "es-ES"
    }
}