package com.example.fronted_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login3)

        val boton3=findViewById<Button>(R.id.button)
        boton3.setOnClickListener {
            val lanzar = Intent(this, Login4::class.java)
            startActivity(lanzar)
        }

    }
}