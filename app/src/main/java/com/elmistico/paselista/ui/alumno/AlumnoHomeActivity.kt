package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AlumnoHomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnohome)

        bottomNav = findViewById(R.id.bottom_nav)

        bottomNav.setOnItemSelectedListener { item ->
            val view = bottomNav.findViewById<View>(item.itemId)
            view.animate().scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction {
                view.animate().scaleX(1f).scaleY(1f).duration = 150
            }

            when (item.itemId) {
                R.id.nav_home -> loadFragment(homeFragment())
                R.id.nav_credencial -> loadFragment(VerCredencialFragment())
                R.id.nav_asistencias -> loadFragment(asistenciasFragment())
                R.id.nav_reportes -> loadFragment(ReportesFragment())
            }
            true
        }

        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_home
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selected_nav_item", bottomNav.selectedItemId)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val selectedItem = savedInstanceState.getInt("selected_nav_item", R.id.nav_home)
        bottomNav.selectedItemId = selectedItem
    }
}
