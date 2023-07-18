package com.example.fronted_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val boton2=findViewById<Button>(R.id.button4)
        boton2.setOnClickListener {
            val lanzar = Intent(this, Login3::class.java)
            startActivity(lanzar)
        }

    }
}