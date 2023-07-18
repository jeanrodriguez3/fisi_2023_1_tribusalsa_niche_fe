package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.fronted_01.conecction.C_api_gestion_Especialidad
import com.example.fronted_01.conecction.C_api_gestion_Medico
import com.example.fronted_01.conecction.Especialidad
import com.example.fronted_01.conecction.Medico
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Especialidad_busqueda : AppCompatActivity() {

    private lateinit var especialidadEditText0: TextView
    private lateinit var especialidadEditText1: TextView
    private lateinit var especialidadEditText2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad_busqueda)

        especialidadEditText0 =  findViewById<TextView>(R.id.textView45)
        especialidadEditText1 =  findViewById<TextView>(R.id.textView44)
        especialidadEditText2 =  findViewById<TextView>(R.id.textView46)

        val boton15=findViewById<Button>(R.id.button121)
        boton15.setOnClickListener {
            val lanzar = Intent(this, Menu_principal::class.java)
            startActivity(lanzar)
        }

        val boton17=findViewById<ImageButton>(R.id.imageButton40)
        boton17.setOnClickListener {
            val lanzar = Intent(this, Especialidad_detalle::class.java)
            startActivity(lanzar)
        }

        generarEspecialidades()
    }

    private fun generarEspecialidades() {
        val especialidades = ArrayList<Especialidad>()
        val retrofitTraer = C_api_gestion_Especialidad.consumirAPI.getTraerEspecialidades()

        retrofitTraer.enqueue(object : Callback<List<Especialidad>> {
            override fun onResponse(call: Call<List<Especialidad>>, response: Response<List<Especialidad>>) {
                if (response.isSuccessful) {
                    val especialidadesResponse = response.body()
                    especialidadesResponse?.let {
                        val EspecialidadData0 = especialidadesResponse.get(0)
                        especialidadEditText0.setText(EspecialidadData0.nombre)

                        var EspecialidadData1 = especialidadesResponse.get(1)
                        especialidadEditText1.setText(EspecialidadData1.nombre)

                        val EspecialidadData2 = especialidadesResponse.get(2)
                        especialidadEditText2.setText(EspecialidadData2.nombre)
                        //productos.add(PedidosLista(pedido.dni pedido.nombreProducto, pedido.precio, pedido.cantidadProducto, pedido.fechaPedido, pedido.foto))

                    }
                }else{
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