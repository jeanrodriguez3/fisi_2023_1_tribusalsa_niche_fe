package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Spinner
import com.example.fronted_01.conecction.C_api_gestion_Especialidad
import com.example.fronted_01.conecction.C_api_gestion_Medico
import com.example.fronted_01.conecction.Especialidad
import com.example.fronted_01.conecction.Medico
import com.example.fronted_01.conecction.Horario
import android.app.DatePickerDialog
import android.content.SharedPreferences
import android.util.Log
import android.widget.ArrayAdapter
import java.util.Calendar
import android.widget.Toast
import com.example.fronted_01.conecction.C_api_gestion_Horario
import com.example.fronted_01.conecction.RegistroCita
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fecha1 : AppCompatActivity() {
    private lateinit var nombreText: TextView
    private lateinit var especialidadText: TextView
    private lateinit var fechaText: TextView
    private lateinit var spinner: Spinner

    private var idEspecialidad: Int = 1
    private var fechaConFormato: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fecha1)

        nombreText = findViewById<TextView>(R.id.textMedico)
        especialidadText = findViewById<TextView>(R.id.textEspecialidad)
        fechaText = findViewById<TextView>(R.id.textFecha)
        spinner = findViewById<Spinner>(R.id.spinner)

        val objIntent: Intent = intent
        val idMedico = objIntent.getIntExtra("idMedico", 0)

        val botonFecha=findViewById<Button>(R.id.seleccionarFecha)
        botonFecha.setOnClickListener {
            mostrarSeleccionFecha()
        }

        val boton28=findViewById<Button>(R.id.button15)
        boton28.setOnClickListener {
            finish()
        }

        val boton29=findViewById<Button>(R.id.button16)
        boton29.setOnClickListener {
            guardarCitaDatosPref()
            val lanzar = Intent(this, Pago::class.java)
            startActivity(lanzar)
        }

        seleccionarMedico(idMedico)
        mostrarHorarios(idMedico)
    }

    private fun seleccionarMedico(id: Int){
        val retrofitTraer = C_api_gestion_Medico.consumirAPI.getTraerMedicosPorID(id)

        retrofitTraer.enqueue(object : Callback<List<Medico>> {
            override fun onResponse(call: Call<List<Medico>>, response: Response<List<Medico>>) {
                if (response.isSuccessful) {
                    val medicosResponse = response.body()
                    medicosResponse?.let {
                        val medicoData0 = medicosResponse.get(0)
                        nombreText.setText(medicoData0.nombre_completo)
                        especialidadText.setText(medicoData0.nombre)
                        idEspecialidad = medicoData0.especialidades_especialidad_id
                    }
                }else{
                    nombreText.setText(response.toString())
                }
            }

            override fun onFailure(call: Call<List<Medico>>, t: Throwable) {
                // Manejar el error de la llamada a la API
                nombreText.setText(t.toString())
            }
        })
    }

    private fun mostrarHorarios(id: Int){
        val retrofitTraer = C_api_gestion_Horario.consumirAPI.getTraerHorariosPorMedico(id)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)

        retrofitTraer.enqueue(object : Callback<List<Horario>> {
            override fun onResponse(call: Call<List<Horario>>, response: Response<List<Horario>>) {
                if (response.isSuccessful) {
                    val horariosResponse = response.body()
                    horariosResponse?.let {
                        it.forEach { pedido ->
                            adapter.add("${pedido.horario_id} - De ${pedido.hora_inicio} a ${pedido.hora_fin}")
                        }
                    }

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = adapter
                }else{
                    nombreText.setText(response.toString())
                }
            }

            override fun onFailure(call: Call<List<Horario>>, t: Throwable) {
                // Manejar el error de la llamada a la API
                nombreText.setText(t.toString())
            }
        })
    }

    private fun mostrarSeleccionFecha(){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        String.format("%02d", calendar.get(Calendar.MONTH) + 1)
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->

            // Hacer algo con la fecha seleccionada
            val calendarSeleccionada = Calendar.getInstance()
            calendarSeleccionada.set(selectedYear, selectedMonth, selectedDay)
            val calendarActual = Calendar.getInstance()

            if(calendarSeleccionada.after(calendarActual)){
                val d = String.format("%02d", selectedDay)
                val m = String.format("%02d", selectedMonth + 1)
                val y = selectedYear

                val fechaSeleccionada = "$d-$m-$y"
                fechaConFormato = "$y-$m-$d"

                fechaText.setText(fechaSeleccionada)
                Toast.makeText(this, "Fecha seleccionada: $fechaSeleccionada", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Selecciona una Fecha posterior al día de hoy", Toast.LENGTH_SHORT).show()
            }

        }, year, month, day)


        datePickerDialog.show()
    }

    private fun guardarCitaDatosPref(){
        val idSplit =  spinner.selectedItem.toString().split("-")
        val idHorario =  idSplit[0].trim().toInt()

        val objIntent: Intent = intent
        val idMedico = objIntent.getIntExtra("idMedico", 0)

        val idEspecialidad = idEspecialidad
        val idUsuario: Int = 1
        val fecha: String = fechaText.text.toString()
        val fechaFormato: String = fechaConFormato

        val horario =  spinner.selectedItem.toString()
        val medico = nombreText.text.toString()
        val especialidad = especialidadText.text.toString()

        val sharedPreferences  = getSharedPreferences("datosCita", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("idHorario", idHorario)
        editor.putInt("idMedico", idMedico)
        editor.putInt("idEspecialidad", idEspecialidad)
        editor.putInt("idUsuario", idUsuario)
        editor.putString("horario", horario)
        editor.putString("medico", medico)
        editor.putString("especialidad", especialidad)
        editor.putString("fecha", fecha)
        editor.putString("fechaFormato", fechaFormato)

        editor.apply()
    }
}