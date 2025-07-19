package com.elmistico.paselista.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.elmistico.paselista.R
import com.elmistico.paselista.ui.registro.RegistroActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val googleBtn = findViewById<ImageView>(R.id.imageView)
        val appleBtn = findViewById<ImageView>(R.id.imageView2)
        val fbBtn = findViewById<ImageView>(R.id.imageView3)
        val forgot = findViewById<TextView>(R.id.textView3)
        val textViewRegistrer = findViewById<TextView>(R.id.textViewRegistrer)

        googleBtn.setOnClickListener{
            Toast.makeText(this, "Iniciar sesión con Google", Toast.LENGTH_SHORT).show()
        }
        appleBtn.setOnClickListener{
            Toast.makeText(this, "Iniciar sesión con Apple", Toast.LENGTH_SHORT).show()
        }
        fbBtn.setOnClickListener{
            Toast.makeText(this, "Iniciar sesión con Facebook", Toast.LENGTH_SHORT).show()
        }
        forgot.setOnClickListener{
            Toast.makeText(this,"Olvidaste tu contraseña???", Toast.LENGTH_SHORT).show()
        }

        textViewRegistrer.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}