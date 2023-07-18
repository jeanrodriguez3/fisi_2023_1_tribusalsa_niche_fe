package com.example.fronted_01.conecction

data class Medico(
    val medico_id: Int,
    val especialidades_especialidad_id: Int,
    val nombre_completo: String,
    val dni: String,
    val n_consultorio: Int,
    val url_foto: String,
    val nombre: String
)