package com.example.fronted_01.conecction

import retrofit2.http.*
import retrofit2.*

interface ConsumirAPI_Horario {
    @GET("/sm_health/ne-gestion-horarios/servicio-al-cliente/v1/consultar-horarios-por-medico/{id}")
    fun getTraerHorariosPorMedico(@Path("id") id: Int): Call<List<Horario>>
}

