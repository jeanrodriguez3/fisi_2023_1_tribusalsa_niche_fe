package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.fronted_01.conecction.C_api_gestion_Cita
import com.example.fronted_01.conecction.RegistroCita
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Resumen : AppCompatActivity() {
    private lateinit var nombreMedico: TextView
    private lateinit var nombreEspecialidad: TextView
    private lateinit var textoFecha: TextView
    private lateinit var textoHora: TextView
    private lateinit var textoMonto: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        nombreMedico = findViewById<TextView>(R.id.medicoText)
        nombreEspecialidad = findViewById<TextView>(R.id.especialidadText)
        textoFecha = findViewById<TextView>(R.id.fechaText)
        textoHora = findViewById<TextView>(R.id.horaText)


        val boton35 = findViewById<Button>(R.id.button16)
        boton35.setOnClickListener {
            registrarCita()
            val lanzar = Intent(this, Pago_exitoso::class.java)
            startActivity(lanzar)
            finish()
        }

        val botonRegresar = findViewById<Button>(R.id.button15)
        botonRegresar.setOnClickListener {
            finish()
        }

        mostrarResumen()
    }

    private fun registrarCita() {
        val sharedPreferences = getSharedPreferences("datosCita", Context.MODE_PRIVATE)

        val idHorario = sharedPreferences.getInt("idHorario", 0)
        val idMedico = sharedPreferences.getInt("idMedico", 0)
        val idEspecialidad = sharedPreferences.getInt("idEspecialidad", 0)
        val idUsuario = sharedPreferences.getInt("idUsuario", 0)
        val fecha = sharedPreferences.getString("fechaFormato", "") ?: ""

        val bodyCita = RegistroCita(idHorario, idMedico, idEspecialidad, idUsuario, fecha)
        val retrofitPoner = C_api_gestion_Cita.consumirAPI.postRegistrarCita(bodyCita)

        retrofitPoner.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // La solicitud fue exitosa
                } else {
                    // Ocurrió un error en la solicitud
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Ocurrió un error en la comunicación con el servidor
            }
        })
    }



    private fun mostrarResumen(){
        val sharedPreferences  = getSharedPreferences("datosCita", Context.MODE_PRIVATE)

        val medico = sharedPreferences.getString("medico", "Error")
        val especialidad = sharedPreferences.getString("especialidad", "Error")
        val fecha = sharedPreferences.getString("fecha", "Error")
        val horario = sharedPreferences.getString("horario", "Error")

        nombreMedico.setText(medico)
        nombreEspecialidad.setText(especialidad)
        textoFecha.setText(fecha)
        textoHora.setText(horario)
    }
}