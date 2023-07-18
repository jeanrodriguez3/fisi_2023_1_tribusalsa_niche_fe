package com.example.fronted_01.conecction

data class Cita(
    val cita_id: Int,
    val horarios_horario_id: Int,
    val medicos_medico_id: Int,
    val especialidades_especialidad_id: Int,
    val usuarios_usuario_id: Int,
    val fecha: String,
    val hora_inicio: String,
    val hora_fin: String,
    val nombre_completo: String,
    val n_consultorio: Int,
    val nombre: String
)