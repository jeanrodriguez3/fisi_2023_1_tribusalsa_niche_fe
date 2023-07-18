package com.example.fronted_01.conecction

import retrofit2.http.*
import retrofit2.*

interface ConsumirAPI_Especialidad {
    @GET("sm_health/ne-gestion-especialidades/servicio-al-cliente/v1/consultar-especialidades")
    fun getTraerEspecialidades(): Call<List<Especialidad>>

    @GET("sm_health/ne-gestion-especialidades/servicio-al-cliente/v1/consultar-especialidades-por-id/{id}")
    fun getTraerEspecialidadesPorID(@Path("id") id: Int): Call<List<Especialidad>>
}

