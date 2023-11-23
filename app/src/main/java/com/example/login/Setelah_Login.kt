package com.example.login

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Setelah_Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setelah_login)

        val textViewUsername = findViewById<TextView>(R.id.textViewUsername)

        val username = intent.getStringExtra("username")

        textViewUsername.text = "Selamat datang, $username"
    }
}
