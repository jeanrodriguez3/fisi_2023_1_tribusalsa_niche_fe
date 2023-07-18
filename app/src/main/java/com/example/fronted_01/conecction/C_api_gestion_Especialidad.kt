package com.example.fronted_01.conecction

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object C_api_gestion_Especialidad {

    private val retrofit= Retrofit.Builder()
        .baseUrl("http://181.65.47.49:25252/")  //esta url cambiar "172.22.224.1" por tu ipv4
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @JvmField
    val consumirAPI= retrofit.create(ConsumirAPI_Especialidad::class.java)

    @JvmField
    val consumirAPI0=retrofit.create(ConsumirAPI_Especialidad::class.java)
}