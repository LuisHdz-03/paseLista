package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AlumnoHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnohome)

        loadFragment(homeFragment())

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            val view = bottomNav.findViewById<View>(item.itemId)
            view.animate().scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction {
                view.animate().scaleX(1f).scaleY(1f).duration = 150
            }
            when (item.itemId) {
                R.id.nav_home -> loadFragment(homeFragment())
                R.id.nav_credencial -> loadFragment(VerCredencialFragment())
                /** R.id.nav_asistencias -> loadFragment(VerAsistenciasFragment())
                R.id.nav_reportes -> loadFragment(VerReportesFragment())*/
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

