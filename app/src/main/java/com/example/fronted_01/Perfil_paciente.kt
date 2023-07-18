package com.example.fronted_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Perfil_paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_paciente)

        val boton9=findViewById<ImageButton>(R.id.imageButton3)
        boton9.setOnClickListener {
            val lanzar = Intent(this, Login4::class.java)
            startActivity(lanzar)
        }

    }
}