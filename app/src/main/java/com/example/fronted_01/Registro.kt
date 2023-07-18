package com.example.fronted_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val boton7=findViewById<ImageButton>(R.id.imageButton2)
        boton7.setOnClickListener {
            val lanzar = Intent(this, Login4::class.java)
            startActivity(lanzar)
        }

    }
}