package com.example.mibocata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class SeleccionBocadillo : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_bocadillo)

        // Referencias a los TextView para bocadillos frío y caliente
        val bocadilloFrioTextView = findViewById<TextView>(R.id.bocadilloFrio)
        val bocadilloCalienteTextView = findViewById<TextView>(R.id.bocadilloCaliente)

        // Listas de opciones de bocadillos
        val bocadillosFrios = listOf(
            "Bocadillo de atún con mayonesa y lechuga",
            "Bocadillo de jamón serrano con tomate",
            "Bocadillo de queso fresco",
            "Bocadillo de salmón ahumado con queso",
            "Bocadillo de pavo con aguacate y tomate",
            "Bocadillo de hummus con zanahoria y pepino",
            "Bocadillo de roast beef con mostaza",
            "Bocadillo de ensalada de huevo con lechuga",
            "Bocadillo de mozzarella, tomate y albahaca",
            "Bocadillo de embutidos variados"
        )

        val bocadillosCalientes = listOf(
            "Bocadillo de bacon con huevo y queso",
            "Bocadillo de lomo con pimientos",
            "Bocadillo de pollo empanado con alioli",
            "Bocadillo de tortilla de patatas",
            "Bocadillo de chorizo a la plancha",
            "Bocadillo de hamburguesa de ternera",
            "Bocadillo de jamón york con bechamel",
            "Bocadillo de albóndigas con salsa de tomate",
            "Bocadillo de calamares con mayonesa y limón",
            "Bocadillo de carne mechada"
        )

        // Obtener el día del año (por ejemplo, 1 para 1 de enero, 365 para 31 de diciembre)
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        // Seleccionar bocadillos en función del día del año
        val bocadilloFrio = bocadillosFrios[dayOfYear % bocadillosFrios.size]
        val bocadilloCaliente = bocadillosCalientes[dayOfYear % bocadillosCalientes.size]

        // Actualizar el texto de los TextView con los bocadillos seleccionados
        bocadilloFrioTextView.text = "Hoy tenemos ${bocadilloFrio}"
        bocadilloCalienteTextView.text = "Hoy tenemos ${bocadilloCaliente}"

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