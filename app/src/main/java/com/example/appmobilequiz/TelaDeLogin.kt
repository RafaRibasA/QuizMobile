package com.example.appmobilequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.appmobilequiz.databinding.ActivityTelaDeLoginBinding
import com.example.appmobilequiz.databinding.CardUserBinding

class TelaDeLogin : AppCompatActivity() {
    lateinit var binding : ActivityTelaDeLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(this, UsuarioDatabase::class.java, "usuarios").build()

        binding.btnLogin.setOnClickListener{
            Thread{
                val listaUsuarios = db.usuarioDao().obterTodosUsers()

                runOnUiThread{
                    for(usuario in listaUsuarios){
                        if(usuario.nome == binding.edUsuario.text.toString()){
                            if(usuario.senha ==  binding.edSenha.text.toString()){
                                startActivity(Intent(this, MainActivity::class.java))
                            }else{
                                binding.edSenha.setError("Senha inválida")
                            }
                        }else{
                            binding.edUsuario.setError("Usuário inválido")
                        }
                    }
                }
            }.start()
        }

        binding.btnCadastrar.setOnClickListener{
            var i = Intent(this, TelaCadastro::class.java)
            startActivity(i)
        }
    }
}