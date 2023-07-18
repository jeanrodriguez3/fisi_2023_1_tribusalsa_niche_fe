package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login4)

        val boton4=findViewById<Button>(R.id.button6)
        boton4.setOnClickListener {
            val lanzar = Intent(this, Menu_principal::class.java)
            startActivity(lanzar)
        }

        val boton5=findViewById<Button>(R.id.button11)
        boton5.setOnClickListener {
            val lanzar = Intent(this, Recuperar_cuenta::class.java)
            startActivity(lanzar)
        }

        val boton6=findViewById<Button>(R.id.button3)
        boton6.setOnClickListener {
            val lanzar = Intent(this, Menu_principal::class.java)
            startActivity(lanzar)
        }

    }
}