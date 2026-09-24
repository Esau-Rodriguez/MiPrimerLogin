package com.example.miprimerlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val usuario = findViewById<EditText>(R.id.txtUsuario)
        val password = findViewById<EditText>(R.id.txtPassword)
        val recuperar = findViewById<TextView>(R.id.lblRecuperarPassword)
        val ingresar = findViewById<Button>(R.id.btnIngresar)
        val registrarse = findViewById<TextView>(R.id.lblCrearCuenta)

        recuperar.setOnClickListener {
            val activityRecuperar = Intent(this, RecuperarPassword::class.java)
            startActivity(activityRecuperar)
        }
        registrarse.setOnClickListener {
            val activityRgistro = Intent(this, CrearCuenta::class.java)
            startActivity(activityRgistro)
        }
        ingresar.setOnClickListener {
            if (usuario.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(this, "Se requiere el usuario y la contraseña", Toast.LENGTH_SHORT).show()
            } else if (usuario.text.toString() == "admin" && password.text.toString() == "1234") {
                Toast.makeText(this, "Bienvenido al sistema", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuario y contraseña incorrecto", Toast.LENGTH_SHORT).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}