package com.curso.android.app.practica.appproyecto_final.vistas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.appproyecto_final.modelos.Textos
import kotlinx.coroutines.launch

class TextoViewModel: ViewModel() {
    val textos : LiveData<Textos> get() = _textos
    private var _textos = MutableLiveData(Textos("", ""))

    fun comparador(txt_uno: String, txt_dos: String) {
        var resultado =  "Son textos iguales."
        var advertencia = ""

        if (!txt_uno.equals(txt_dos)) {
            if (txt_uno.toUpperCase().equals(txt_dos.toUpperCase())) {
                resultado = "No son textos iguales."
                advertencia = "Controle sus mayusculas y minusculas."
            } else {
                resultado = "No son textos iguales."
            }
        }

        actualizarTextos(resultado, advertencia)
    }

    private fun actualizarTextos(resultado:String, advertencia: String) {
        viewModelScope.launch {
            _textos.value = Textos(resultado, advertencia)
        }
    }

    }
