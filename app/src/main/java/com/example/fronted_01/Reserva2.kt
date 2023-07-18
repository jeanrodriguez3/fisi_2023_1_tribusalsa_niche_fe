package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fronted_01.conecction.C_api_gestion_Especialidad
import com.example.fronted_01.conecction.C_api_gestion_Medico
import com.example.fronted_01.conecction.Medico
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Reserva2 : AppCompatActivity() {
    private lateinit var nombreEditText0: TextView
    private lateinit var nombreEditText1: TextView
    private lateinit var nombreEditText2: TextView

    private lateinit var especialidadEditText0: TextView
    private lateinit var especialidadEditText1: TextView
    private lateinit var especialidadEditText2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva2)

        nombreEditText0 = findViewById<TextView>(R.id.textMedico0)
        nombreEditText1 = findViewById<TextView>(R.id.textMedico1)
        nombreEditText2 = findViewById<TextView>(R.id.textMedico2)

        especialidadEditText0 =  findViewById<TextView>(R.id.textEspecialidad0)
        especialidadEditText1 =  findViewById<TextView>(R.id.textEspecialidad1)
        especialidadEditText2 =  findViewById<TextView>(R.id.textEspecialidad2)

        val botonMedico0=findViewById<ImageButton>(R.id.buttonMedico0)
        botonMedico0.setOnClickListener {
            val lanzar = Intent(this, Fecha1::class.java)
            lanzar.putExtra("idMedico", 1)
            startActivity(lanzar)
        }

        val botonMedico1=findViewById<ImageButton>(R.id.buttonMedico1)
        botonMedico1.setOnClickListener {
            val lanzar = Intent(this, Fecha1::class.java)
            lanzar.putExtra("idMedico", 2)
            startActivity(lanzar)
        }

        val botonMedico2=findViewById<ImageButton>(R.id.buttonMedico2)
        botonMedico2.setOnClickListener {
            val lanzar = Intent(this, Fecha1::class.java)
            lanzar.putExtra("idMedico", 3)
            startActivity(lanzar)
        }

        val boton25=findViewById<Button>(R.id.button15)
        boton25.setOnClickListener {
            val lanzar = Intent(this, Reserva1::class.java)
            startActivity(lanzar)
        }

        generarMedicos()
    }

    private fun generarMedicos() {
        val retrofitTraer = C_api_gestion_Medico.consumirAPI.getTraerMedicos()

        retrofitTraer.enqueue(object : Callback<List<Medico>> {
            override fun onResponse(call: Call<List<Medico>>, response: Response<List<Medico>>) {
                if (response.isSuccessful) {
                    val medicosResponse = response.body()
                    medicosResponse?.let {
                        val medicoData0 = medicosResponse.get(0)
                        nombreEditText0.setText(medicoData0.nombre_completo)
                        especialidadEditText0.setText(medicoData0.nombre)

                        var medicoData1 = medicosResponse.get(1)
                        nombreEditText1.setText(medicoData1.nombre_completo)
                        especialidadEditText1.setText(medicoData1.nombre)

                        val medicoData2 = medicosResponse.get(2)
                        nombreEditText2.setText(medicoData2.nombre_completo)
                        especialidadEditText2.setText(medicoData2.nombre)
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