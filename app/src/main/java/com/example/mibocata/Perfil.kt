package com.example.mibocata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        // Configuración de clics en imágenes
        val ficheroImage = findViewById<ImageView>(R.id.imageView2)
        val icono2Image = findViewById<ImageView>(R.id.imageView3)
        val icono3Image = findViewById<ImageView>(R.id.imageView4)
        val logoImage = findViewById<ImageView>(R.id.imageView5)

        ficheroImage.setOnClickListener {
            val intent = Intent(this, HistoricoBocadillo::class.java)
            startActivity(intent)
        }

        icono2Image.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }

        icono3Image.setOnClickListener {
            val intent = Intent(this, RegistroPedido::class.java)
            startActivity(intent)
        }

        logoImage.setOnClickListener {
            val intent = Intent(this, SeleccionBocadillo::class.java)
            startActivity(intent)
        }
    }
}