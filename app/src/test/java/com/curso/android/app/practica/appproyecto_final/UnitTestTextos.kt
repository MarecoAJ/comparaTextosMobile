package com.curso.android.app.practica.appproyecto_final

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.appproyecto_final.vistas.TextoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTestTextos {

    private lateinit var mainViewModel : TextoViewModel

    @get:Rule
    val instansTaskRule = InstantTaskExecutorRule()
    private val dispacher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispacher)
        mainViewModel = TextoViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun textosViewModel_valorInicialArgs() = runTest {
        val valorRes = mainViewModel.textos.value?.resultado
        val valorAdv = mainViewModel.textos.value?.advertencia
        assertEquals("", valorRes)
        assertEquals("", valorAdv)
    }

    @Test
    fun textosViewModel_comparadorIguales() = runTest {
        launch {
            mainViewModel.comparador("", "")
        }
        advanceUntilIdle()

        val valorRes = mainViewModel.textos.value?.resultado
        val valorAdv = mainViewModel.textos.value?.advertencia
        assertEquals("Son textos iguales.", valorRes)
        assertEquals("", valorAdv)
    }

    @Test
    fun textosViewModel_comparadorDistintos() = runTest {
        launch {
            mainViewModel.comparador("hola", "")
        }
        advanceUntilIdle()

        val valorRes = mainViewModel.textos.value?.resultado
        val valorAdv = mainViewModel.textos.value?.advertencia
        assertEquals("No son textos iguales.", valorRes)
        assertEquals("", valorAdv)
    }

    @Test
    fun textosViewModel_comparadorDiferenciaMayusMinus() = runTest {
        launch {
            mainViewModel.comparador("hola", "Hola")
        }
        advanceUntilIdle()

        val valorRes = mainViewModel.textos.value?.resultado
        val valorAdv = mainViewModel.textos.value?.advertencia
        assertEquals("No son textos iguales.", valorRes)
        assertEquals("Controle sus mayusculas y minusculas.", valorAdv)
    }


}