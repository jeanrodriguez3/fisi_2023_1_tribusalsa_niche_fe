package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.fronted_01.conecction.C_api_gestion_Especialidad
import com.example.fronted_01.conecction.Especialidad
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Reserva3 : AppCompatActivity() {
    private lateinit var especialidadEditText0: TextView
    private lateinit var especialidadEditText1: TextView
    private lateinit var especialidadEditText2: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva3)

        especialidadEditText0 =  findViewById<TextView>(R.id.textView45)
        especialidadEditText1 =  findViewById<TextView>(R.id.textView46)
        especialidadEditText2 =  findViewById<TextView>(R.id.textView44)

        val boton26=findViewById<Button>(R.id.esp_res_retroceder)
        boton26.setOnClickListener {
            val lanzar = Intent(this, Reserva1::class.java)
            startActivity(lanzar)
        }

        val esp_doc_1=findViewById<ImageButton>(R.id.Esp_1_Reservar)
        esp_doc_1.setOnClickListener {
            val lanzar = Intent(this, Especialidad_doctor::class.java)
            lanzar.putExtra("idEspecialidad", 1)
            startActivity(lanzar)
        }

        val esp_doc_2=findViewById<ImageButton>(R.id.Esp_2_Reservar)
        esp_doc_2.setOnClickListener {
            val lanzar = Intent(this, Especialidad_doctor::class.java)
            lanzar.putExtra("idEspecialidad", 2)
            startActivity(lanzar)
        }

        val esp_doc_3=findViewById<ImageButton>(R.id.Esp_3_Reservar)
        esp_doc_3.setOnClickListener {
            val lanzar = Intent(this, Especialidad_doctor::class.java)
            lanzar.putExtra("idEspecialidad", 3)
            startActivity(lanzar)
        }

        generarEspecialidades()
    }

    private fun generarEspecialidades() {
        val especialidades = ArrayList<Especialidad>()
        val retrofitTraer = C_api_gestion_Especialidad.consumirAPI.getTraerEspecialidades()

        retrofitTraer.enqueue(object : Callback<List<Especialidad>> {
            override fun onResponse(
                call: Call<List<Especialidad>>,
                response: Response<List<Especialidad>>
            ) {
                if (response.isSuccessful) {
                    val especialidadesResponse = response.body()
                    especialidadesResponse?.let {
                        val EspecialidadData0 = especialidadesResponse.get(0)
                        especialidadEditText0.setText(EspecialidadData0.nombre)

                        var EspecialidadData1 = especialidadesResponse.get(1)
                        especialidadEditText1.setText(EspecialidadData1.nombre)

                        val EspecialidadData2 = especialidadesResponse.get(2)
                        especialidadEditText2.setText(EspecialidadData2.nombre)

                    }
                } else {
                    especialidadEditText0.setText(response.toString())
                }
            }

            override fun onFailure(call: Call<List<Especialidad>>, t: Throwable) {
                // Manejar el error de la llamada a la API
                especialidadEditText0.setText(t.toString())
            }
        })
    }
}

