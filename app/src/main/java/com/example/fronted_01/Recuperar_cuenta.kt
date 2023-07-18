package com.example.fronted_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Recuperar_cuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_cuenta)

        val boton8=findViewById<ImageButton>(R.id.imageButton)
        boton8.setOnClickListener {
            val lanzar = Intent(this, Login4::class.java)
            startActivity(lanzar)
        }

    }
}