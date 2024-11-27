package com.example.mibocata

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoricoBocadillo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_bocadillo)

        // Listas de opciones de bocadillos
        val bocadillosFrios = listOf(
            "Bocadillo de atún con mayonesa y lechuga",
            "Bocadillo de jamón serrano con tomate",
            "Bocadillo de queso fresco"
        )
        val bocadillosCalientes = listOf(
            "Bocadillo de bacon con huevo y queso",
            "Bocadillo de lomo con pimientos",
            "Bocadillo de pollo empanado con alioli"
        )

        // Combina ambas listas con fechas
        val historico = mutableListOf<Pair<String, String>>().apply {
            addAll(bocadillosFrios.map { it to "2024-11-10" }) // Fechas ficticias
            addAll(bocadillosCalientes.map { it to "2024-11-11" })
        }

        // Configurar el adaptador para el ListView
        val adapter = BocadilloAdapter(historico, bocadillosFrios.size)
        val listView = findViewById<ListView>(R.id.listbocata)
        listView.adapter = adapter

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

    class BocadilloAdapter(
        private val historico: List<Pair<String, String>>,
        private val numFrios: Int
    ) : BaseAdapter() {
        override fun getCount(): Int = historico.size
        override fun getItem(position: Int): Pair<String, String> = historico[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bocadillo, parent, false)

            val bocadilloText = view.findViewById<TextView>(R.id.textBocadillo)
            val fechaText = view.findViewById<TextView>(R.id.textFecha)

            val (bocadillo, fecha) = getItem(position)
            bocadilloText.text = bocadillo
            fechaText.text = fecha

            // Colorea la fecha según el tipo de bocadillo
            fechaText.setTextColor(
                if (position < numFrios) Color.GREEN else Color.RED
            )

            return view
        }
    }
}
