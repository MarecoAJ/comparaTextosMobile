package com.curso.android.app.practica.appproyecto_final.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.appproyecto_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: TextoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.textos.observe(this){

            binding.tviewResultado.text = it.resultado
            binding.tviewAdvertencia.text = it.advertencia
        }

        binding.bttComparar.setOnClickListener {
            mainViewModel.comparador(binding.etxtPrimerTexto.text.toString(), binding.etxtSegundoTexto.text.toString() )
        }
    }
}