package com.example.fronted_01.conecction

import retrofit2.http.*
import retrofit2.*

interface ConsumirAPI_Medico {
    @GET("sm_health/ne-gestion-medicos/servicio-al-cliente/v1/consultar-medicos")
    fun getTraerMedicos(): Call<List<Medico>>

    @GET("sm_health/ne-gestion-medicos/servicio-al-cliente/v1/consultar-medicos-por-id/{id}")
    fun getTraerMedicosPorID(@Path("id") id: Int): Call<List<Medico>>

    @GET("sm_health/ne-gestion-medicos/servicio-al-cliente/v1/consultar-medicos-por-especialidad/{id}")
    fun getTraerMedicosPorEspecialidad(@Path("id") id: Int): Call<List<Medico>>

}

