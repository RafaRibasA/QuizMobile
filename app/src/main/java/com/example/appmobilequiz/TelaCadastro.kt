package com.example.appmobilequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.appmobilequiz.databinding.ActivityTelaCadastroBinding

class TelaCadastro : AppCompatActivity() {
    lateinit var binding: ActivityTelaCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(this, UsuarioDatabase::class.java, "usuarios").build()

        binding.btnCadastrarUser.setOnClickListener{
            val usuario = User(nome = binding.edUsuarioCadastro.text.toString(),
                senha = binding.edSenhaCadastro.text.toString())

            Thread{
                db.usuarioDao().inserirUser(usuario)
                finish()
            }.start()
        }
    }
}