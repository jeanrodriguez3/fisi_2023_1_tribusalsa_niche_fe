package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Fecha2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fecha2)

        val boton30=findViewById<Button>(R.id.button15)
        boton30.setOnClickListener {
            val lanzar = Intent(this, Reserva3::class.java)
            startActivity(lanzar)
        }

        val boton31=findViewById<Button>(R.id.button16)
        boton31.setOnClickListener {
            val lanzar = Intent(this, Pago::class.java)
            startActivity(lanzar)
        }
    }
}