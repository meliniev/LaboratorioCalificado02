package com.nieves.melanie.usolayoutsv4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Ejercicio01Activity : AppCompatActivity() {
    private lateinit var boxGreen: CardView
    private lateinit var showButton: Button
    private lateinit var hideButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        // Inicializar las vistas
        boxGreen = findViewById(R.id.boxGreen)
        showButton = findViewById(R.id.showButton)
        hideButton = findViewById(R.id.hideButton)

        // Configurar el botón "Mostrar"
        showButton.setOnClickListener {
            boxGreen.visibility = View.VISIBLE
        }

        // Configurar el botón "Ocultar"
        hideButton.setOnClickListener {
            boxGreen.visibility = View.GONE // Cambiado a GONE para liberar el espacio
        }
    }
}
