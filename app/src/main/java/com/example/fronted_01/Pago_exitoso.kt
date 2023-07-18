package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pago_exitoso : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_exitoso)

        val botonFinal = findViewById<Button>(R.id.Continuar_Final)
        botonFinal.setOnClickListener {
            finish()
            val lanzar = Intent(this, Menu_principal::class.java)
            startActivity(lanzar)

        }
    }
}