package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu_principal : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val boton10=findViewById<Button>(R.id.button13)
        boton10.setOnClickListener {
            val lanzar = Intent(this, Doctor_busqueda::class.java)
            startActivity(lanzar)
        }
        val boton16=findViewById<Button>(R.id.button14)
        boton16.setOnClickListener {
            val lanzar = Intent(this, Especialidad_busqueda::class.java)
            startActivity(lanzar)
        }
        val boton20=findViewById<Button>(R.id.button17)
        boton20.setOnClickListener {
            val lanzar = Intent(this, Reserva1::class.java)
            startActivity(lanzar)
        }


    }
}