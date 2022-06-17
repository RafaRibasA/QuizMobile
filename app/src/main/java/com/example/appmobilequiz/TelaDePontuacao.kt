package com.example.appmobilequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.appmobilequiz.databinding.ActivityTelaDePontuacaoBinding

class TelaDePontuacao : AppCompatActivity() {
    lateinit var binding : ActivityTelaDePontuacaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDePontuacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pontuacao =  intent.getIntExtra("score",0)

        binding.txtPontuacao.text = pontuacao.toString()

        val db = Room.databaseBuilder(this, ScoreDatabase::class.java, "scores").build()

        binding.btnSalvarScore.setOnClickListener{
            val score = Score(
                nome = binding.edNoneScore.text.toString(),
                pontuacao = pontuacao
            )

            Thread{
                db.scoreDao().inserir(score)
                voltarParaOMenu()
            }.start()
        }

        binding.btnVoltarMenu.setOnClickListener{
            voltarParaOMenu()
        }
    }

    fun voltarParaOMenu(){
        finishAffinity()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}