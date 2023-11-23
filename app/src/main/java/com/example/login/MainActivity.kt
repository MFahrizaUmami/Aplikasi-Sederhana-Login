package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.button_login)
        editTextUsername = findViewById(R.id.username)
        editTextPassword = findViewById(R.id.password)

        btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_login -> {
                val username = editTextUsername.text.toString().trim()
                val password = editTextPassword.text.toString().trim()

                if (ValidasiLogin(username, password)) {
                    val intent = Intent(this, Setelah_Login::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Username atau password tidak valid. Silakan cek kembali.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun ValidasiLogin(username: String, password: String): Boolean {
        val validCredentials = mapOf(
            "Fahriza@gmail.com" to "password1",
            "Umami@gmail.com" to "password2",
            "Novi@gmail.com" to "password3"
        )

        return validCredentials[username] == password
    }
}
