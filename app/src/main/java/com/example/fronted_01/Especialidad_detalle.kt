package com.example.fronted_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Especialidad_detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad_detalle)

        val boton18=findViewById<Button>(R.id.button12)
        boton18.setOnClickListener {
            val lanzar =Intent(this, Especialidad_busqueda::class.java)
            startActivity(lanzar)
        }

    }
}