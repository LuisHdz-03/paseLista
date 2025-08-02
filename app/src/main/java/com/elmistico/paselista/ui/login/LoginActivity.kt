package com.elmistico.paselista.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.elmistico.paselista.R
import com.elmistico.paselista.ui.alumno.AlumnoHomeActivity
import com.elmistico.paselista.ui.docente.DocenteHomeActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtforgot = findViewById<TextView>(R.id.textView3)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnLogin.setOnClickListener {
            val intent = Intent(this, AlumnoHomeActivity::class.java)
            startActivity(intent)
        }
        txtforgot.setOnClickListener {
            Toast.makeText(this, "como tu te iama io no c", Toast.LENGTH_SHORT).show()
        }

    }
}