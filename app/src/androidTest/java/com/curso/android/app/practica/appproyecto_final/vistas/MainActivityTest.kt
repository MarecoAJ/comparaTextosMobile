package com.curso.android.app.practica.appproyecto_final.vistas

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.curso.android.app.practica.appproyecto_final.R

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule : ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_comparar(){
        Espresso.onView(
            ViewMatchers.withId(R.id.btt_comparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.tview_resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son textos iguales.")
            )
        )

    }
}