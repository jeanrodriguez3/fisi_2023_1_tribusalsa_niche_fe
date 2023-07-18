package com.example.fronted_01.conecction

import retrofit2.http.*
import retrofit2.*

interface ConsumirAPI_Cita {
    @POST("/sm_health/ne-gestion-reservas/servicio-al-cliente/v1/registrar-citas")
    fun postRegistrarCita(@Body body: RegistroCita): Call<Void>

    @GET("/sm_health/ne-gestion-reservas/servicio-al-cliente/v1/consultar-citas/{id}")
    fun getTraerCitasPorID(@Path("id") id: Int): Call<List<Cita>>
}

