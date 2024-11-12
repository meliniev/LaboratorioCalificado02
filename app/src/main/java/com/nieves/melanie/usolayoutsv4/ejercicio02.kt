package com.nieves.melanie.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nieves.melanie.usolayoutsv4.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            if (validateInputs()) {
                val intent = Intent(this, OrderDetailsActivity::class.java).apply {
                    putExtra("nombreCliente", binding.etNombreCliente.text.toString())
                    putExtra("numeroCliente", binding.etNumeroCliente.text.toString())
                    putExtra("productos", binding.etProductos.text.toString())
                    putExtra("ciudad", binding.etCiudad.text.toString())
                    putExtra("direccion", binding.etDireccion.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        return binding.etNombreCliente.text.isNotEmpty() &&
                binding.etNumeroCliente.text.isNotEmpty() &&
                binding.etProductos.text.isNotEmpty() &&
                binding.etCiudad.text.isNotEmpty() &&
                binding.etDireccion.text.isNotEmpty()
    }
}
