package com.example.mibocata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameField = findViewById(R.id.username)
        passwordField = findViewById(R.id.password)
        loginButton = findViewById(R.id.reserva_button)

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (username == "admin" && password == "1234") {
                val intent = Intent(this, SeleccionBocadillo::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Ha introducido mal su Usuario o Contraseña. Vuelva a intentarlo.", Toast.LENGTH_SHORT).show()
                usernameField.text.clear()
                passwordField.text.clear()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Limpiar los campos de texto al regresar a esta actividad
        usernameField.text.clear()
        passwordField.text.clear()
    }
}

