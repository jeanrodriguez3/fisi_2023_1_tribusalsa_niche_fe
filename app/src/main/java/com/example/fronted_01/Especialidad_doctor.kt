package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.fronted_01.conecction.C_api_gestion_Medico
import com.example.fronted_01.conecction.Medico
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Especialidad_doctor : AppCompatActivity() {
    private lateinit var nombreEditText0: TextView
    private lateinit var nombreEditText1: TextView
    private lateinit var nombreEditText2: TextView

    private lateinit var especialidadEditText0: TextView
    private lateinit var especialidadEditText1: TextView
    private lateinit var especialidadEditText2: TextView

    private var idSelected1: Int = 0
    private var idSelected2: Int = 0
    private var idSelected3: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad_doctor)

        nombreEditText0 = findViewById<TextView>(R.id.blo1_top_doc_esp)
        nombreEditText1 = findViewById<TextView>(R.id.blo2_top_doc_esp)
        nombreEditText2 = findViewById<TextView>(R.id.blo3_top_doc_esp)

        especialidadEditText0 =  findViewById<TextView>(R.id.blo1_bottom_doc_esp)
        especialidadEditText1 =  findViewById<TextView>(R.id.blo2_bottom_doc_esp)
        especialidadEditText2 =  findViewById<TextView>(R.id.blo3_bottom_doc_esp)

        val objIntent: Intent = intent
        val idEspecialidad = objIntent.getIntExtra("idEspecialidad", 0)

        val RegresarEspDoc=findViewById<Button>(R.id.esp_doc_regresar)
        RegresarEspDoc.setOnClickListener {
            val lanzar = Intent(this, Reserva3::class.java)
            startActivity(lanzar)
        }

        val doc_1=findViewById<ImageButton>(R.id.Esp_Doc_1_Reservar_Sub)
        doc_1.setOnClickListener {
            val lanzar = Intent(this, Fecha1::class.java)
            lanzar.putExtra("idMedico", idSelected1)
            startActivity(lanzar)
        }

        val doc_2=findViewById<ImageButton>(R.id.Esp_Doc_2_Reservar_Sub)
        doc_2.setOnClickListener {
            val lanzar = Intent(this, Fecha1::class.java)
            lanzar.putExtra("idMedico", idSelected2)
            startActivity(lanzar)
        }

        val doc_3=findViewById<ImageButton>(R.id.Esp_Doc_3_Reservar_Sub)
        doc_3.setOnClickListener {
            val lanzar = Intent(this, Fecha1::class.java)
            lanzar.putExtra("idMedico", idSelected3)
            startActivity(lanzar)
        }
        generarMedicos(idEspecialidad)
    }

    private fun generarMedicos(id: Int) {
        val medicos = ArrayList<Medico>()
        val retrofitTraer = C_api_gestion_Medico.consumirAPI.getTraerMedicosPorEspecialidad(id)

        retrofitTraer.enqueue(object : Callback<List<Medico>> {
            override fun onResponse(call: Call<List<Medico>>, response: Response<List<Medico>>) {
                if (response.isSuccessful) {
                    val medicosResponse = response.body()
                    medicosResponse?.let {
                        val medicoData0 = medicosResponse.get(0)
                        nombreEditText0.setText(medicoData0.nombre_completo)
                        especialidadEditText0.setText(medicoData0.nombre)
                        idSelected1 = medicoData0.medico_id

                        var medicoData1 = medicosResponse.get(1)
                        nombreEditText1.setText(medicoData1.nombre_completo)
                        especialidadEditText1.setText(medicoData1.nombre)
                        idSelected2 = medicoData1.medico_id

                        val medicoData2 = medicosResponse.get(2)
                        nombreEditText2.setText(medicoData2.nombre_completo)
                        especialidadEditText2.setText(medicoData2.nombre)
                        idSelected3 = medicoData2.medico_id
                    }
                }else{
                    nombreEditText1.setText(response.toString())
                }
            }

            override fun onFailure(call: Call<List<Medico>>, t: Throwable) {
                // Manejar el error de la llamada a la API
                nombreEditText1.setText(t.toString())
            }
        })
    }
}