package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Reserva1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva1)

        val boton21=findViewById<Button>(R.id.button15)
        boton21.setOnClickListener {
            val lanzar = Intent(this, Menu_principal::class.java)
            startActivity(lanzar)
        }

        val boton22=findViewById<ImageButton>(R.id.imageButton18)
        boton22.setOnClickListener {
            val lanzar = Intent(this, Reserva2::class.java)
            startActivity(lanzar)
        }

        val boton23=findViewById<ImageButton>(R.id.imageButton19)
        boton23.setOnClickListener {
            val lanzar = Intent(this, Reserva3::class.java)
            startActivity(lanzar)
        }

    }
}