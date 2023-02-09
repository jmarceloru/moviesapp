package com.jmarcelo.moviesapp.commons

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket

object InternetCheck {

    suspend fun isNetworkAvailable() = coroutineScope {
        return@coroutineScope try{
            val sock = Socket()
            val sockectAddress = InetSocketAddress("8.8.8.8",53)
            withContext(Dispatchers.IO) {
                sock.connect(sockectAddress, 2000)
                sock.close()
                true
            }
        }catch (ex: Exception){
            false
        }
    }
}