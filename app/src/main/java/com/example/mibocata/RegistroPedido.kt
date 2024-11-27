package com.example.mibocata

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegistroPedido : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_pedido)

        // Mostrar los bocadillos del día siguiente
        mostrarBocadillosDelDiaSiguiente()

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

    data class Bocadillo(val nombre: String, val tipo: String, val fecha: String)

    private fun mostrarBocadillosDelDiaSiguiente() {
        val bocadillos = mutableListOf<Bocadillo>()

        val calendar = Calendar.getInstance()
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        val bocadillosFrios = obtenerBocadillosFriosParaSemana()
        val bocadillosCalientes = obtenerBocadillosCalientesParaSemana()

        for (i in 0..3) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            val fecha = formatoFecha.format(calendar.time)

            // Añadir bocadillo frío a la izquierda
            bocadillos.add(Bocadillo(bocadillosFrios[i], "frío", fecha))
            // Añadir bocadillo caliente a la derecha
            bocadillos.add(Bocadillo(bocadillosCalientes[i], "caliente", fecha))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewBocadillos)

        // Usar GridLayoutManager con 2 columnas
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = BocadilloAdapter(bocadillos)

        // Mostrar el bocadillo del día siguiente en los TextViews
        val bocadilloFrioTextView = findViewById<TextView>(R.id.bocadilloFrio)
        val bocadilloCalienteTextView = findViewById<TextView>(R.id.bocadilloCaliente)
        bocadilloFrioTextView.text = obtenerBocadilloFrioDelDiaSiguiente()
        bocadilloCalienteTextView.text = obtenerBocadilloCalienteDelDiaSiguiente()
    }

    private fun obtenerBocadillosFriosParaSemana(): List<String> {
        val bocadillosFrios = listOf(
            "Bocadillo de atún con mayonesa y lechuga",
            "Bocadillo de jamón serrano con tomate",
            "Bocadillo de queso fresco",
            "Bocadillo de salmón ahumado",
            "Bocadillo de pavo con aguacate y tomate",
            "Bocadillo de hummus con zanahoria y pepino",
            "Bocadillo de roast beef con mostaza",
            "Bocadillo de ensalada de huevo con lechuga",
            "Bocadillo de mozzarella, tomate y albahaca",
            "Bocadillo de embutidos variados"
        )
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        return (dayOfYear until dayOfYear + 7).map {
            bocadillosFrios[it % bocadillosFrios.size]
        }
    }

    private fun obtenerBocadillosCalientesParaSemana(): List<String> {
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
            "Bocadillo de carne mechada con salsa"
        )
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        return (dayOfYear until dayOfYear + 7).map {
            bocadillosCalientes[it % bocadillosCalientes.size]
        }
    }

    // Función para obtener el bocadillo frío del día siguiente
    private fun obtenerBocadilloFrioDelDiaSiguiente(): String {
        val bocadillosFrios = listOf(
            "Bocadillo de atún con mayonesa y lechuga",
            "Bocadillo de jamón serrano con tomate",
            "Bocadillo de queso fresco",
            "Bocadillo de salmón ahumado",
            "Bocadillo de pavo con aguacate y tomate",
            "Bocadillo de hummus con zanahoria y pepino",
            "Bocadillo de roast beef con mostaza",
            "Bocadillo de ensalada de huevo con lechuga",
            "Bocadillo de mozzarella, tomate y albahaca",
            "Bocadillo de embutidos variados"
        )
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR) + 1 // Sumar 1 para el día siguiente
        return bocadillosFrios[dayOfYear % bocadillosFrios.size]
    }

    // Función para obtener el bocadillo caliente del día siguiente
    private fun obtenerBocadilloCalienteDelDiaSiguiente(): String {
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
            "Bocadillo de carne mechada con salsa"
        )
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR) + 1 // Sumar 1 para el día siguiente
        return bocadillosCalientes[dayOfYear % bocadillosCalientes.size]
    }

    class BocadilloAdapter(private val bocadillos: List<Bocadillo>) :
        RecyclerView.Adapter<BocadilloAdapter.BocadilloViewHolder>() {

        class BocadilloViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nombreTextView: TextView = itemView.findViewById(R.id.textBocadillo)
            val fechaTextView: TextView = itemView.findViewById(R.id.textFecha)
            val colorTextView: TextView = itemView.findViewById(R.id.textColor)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BocadilloViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bocadillo, parent, false)
            return BocadilloViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: BocadilloViewHolder, position: Int) {
            val bocadillo = bocadillos[position]
            holder.nombreTextView.text = bocadillo.nombre
            holder.fechaTextView.text = bocadillo.fecha

            val color = if (bocadillo.tipo == "frío") Color.GREEN else Color.RED
            holder.fechaTextView.setTextColor(color) // Aplicar color al TextView de la fecha
        }

        override fun getItemCount(): Int = bocadillos.size
    }
}