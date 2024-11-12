package com.nieves.melanie.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nieves.melanie.usolayoutsv4.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del Intent
        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        // Mostrar datos en los TextViews
        binding.tvNombreCliente.text = nombreCliente
        binding.tvNumeroCliente.text = numeroCliente
        binding.tvProductos.text = productos
        binding.tvUbicacion.text = direccion

        // Acción del botón "LLAMAR"
        binding.btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intent)
        }

        // Acción del botón "WSP"
        binding.btnWsp.setOnClickListener {
            val mensaje = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/?text=${Uri.encode(mensaje)}")
            }
            startActivity(intent)
        }

        // Acción del botón "MAPS"
        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=${Uri.encode(direccion)}")
            }
            startActivity(intent)
        }
    }
}
