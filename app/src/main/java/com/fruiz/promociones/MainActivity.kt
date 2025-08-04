package com.fruiz.promociones

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)

        // Cargar fragmento inicial
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, PromocionesFragment())
            .commit()

        // Escuchar selección de ítems
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_promociones -> {
                    replaceFragment(PromocionesFragment())
                    true
                }
                R.id.nav_registro -> {
                    replaceFragment(RegistroFragment())
                    true
                }
                R.id.nav_detalle -> {
                    replaceFragment(DetalleFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}