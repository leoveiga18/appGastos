package com.example.appgastos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtendo referências para os EditTexts e TextView onde serão inseridos os valores e o resultado
        val editTextDistance = findViewById<EditText>(R.id.editTextDistance)
        val editTextAutonomia = findViewById<EditText>(R.id.editTextAutonomia)
        val textViewGasto = findViewById<TextView>(R.id.textViewGasto)

        // Obtendo referência para o botão de calcular
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        // Definindo um listener de clique para o botão de calcular
        buttonCalculate.setOnClickListener {
            // Seu código para calcular o gasto aqui
        }

        // Obtendo referência para o botão de mapa
        val buttonMap = findViewById<Button>(R.id.buttonMap)

        // Definindo um listener de clique para o botão de mapa
        buttonMap.setOnClickListener {
            openMaps()
        }
    }

    private fun openMaps() {
        val latitude = 37.4219999
        val longitude = -122.0840575

        // Criando uma URI para abrir o Google Maps na localização desejada no navegador nativo
        val mapIntentUri = Uri.parse("https://www.google.com/maps?q=$latitude,$longitude")

        // Criando uma Intent com a URI
        val mapIntent = Intent(Intent.ACTION_VIEW, mapIntentUri)

        // Verificando se existe algum aplicativo capaz de lidar com a Intent
        if (mapIntent.resolveActivity(packageManager) != null) {
            // Abrindo o Google Maps no navegador nativo
            startActivity(mapIntent)
        } else {
            // Exibindo uma mensagem caso não seja possível abrir o Google Maps
            Toast.makeText(this, "Não foi possível abrir o Google Maps", Toast.LENGTH_SHORT).show()
        }
    }

}
