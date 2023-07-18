package com.example.fronted_01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Pago : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago)

        val boton32=findViewById<Button>(R.id.button15)
        boton32.setOnClickListener {
            finish()
        }

        val boton33=findViewById<Button>(R.id.button16)
        boton33.setOnClickListener {
            val lanzar = Intent(this, Resumen::class.java)
            startActivity(lanzar)
        }

    }
}