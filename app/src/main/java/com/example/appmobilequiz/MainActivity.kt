package com.example.appmobilequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmobilequiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComecar.setOnClickListener{
            val i = Intent(this, TelaDeQuestoes::class.java)
            startActivity(i)
        }

        binding.btnPontuacao.setOnClickListener{
            val i = Intent(this, ListaDePontuacao::class.java)
            startActivity(i)
        }
    }
}