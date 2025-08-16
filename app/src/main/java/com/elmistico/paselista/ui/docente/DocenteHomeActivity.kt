package com.elmistico.paselista.ui.docente

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class DocenteHomeActivity : AppCompatActivity() {

    private lateinit var nav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docente_home)

        nav = findViewById(R.id.bootom_nav_docente)

        if (savedInstanceState == null) {

            nav.selectedItemId = R.id.nav_grupasignados
        }

        nav.setOnItemSelectedListener { item ->
            val view = nav.findViewById<View>(item.itemId)
            view.animate().scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction {
                view.animate().scaleX(1f).scaleY(1f).duration = 150
            }

            when (item.itemId) {
                R.id.nav_grupasignados -> LoadFragment(GruposFragment())
                R.id.nav_list -> LoadFragment(ListasFragment())
                R.id.nav_report -> LoadFragment(RepotesFragment())
                R.id.nav_perfil -> LoadFragment(PerfilDocenteFragment())
            }
            true
        }
        if (savedInstanceState == null) {

            nav.selectedItemId = R.id.nav_grupasignados
        }
    }


    private fun LoadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_docente, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selected_nav_item", nav.selectedItemId)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val selectedItem = savedInstanceState.getInt("selected_nav_item", R.id.nav_grupasignados)
        nav.selectedItemId = selectedItem
    }
}
