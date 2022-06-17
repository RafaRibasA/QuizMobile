package com.example.appmobilequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.appmobilequiz.databinding.ActivityListaDePontuacaoBinding
import com.example.appmobilequiz.databinding.CardScoreBinding

class ListaDePontuacao : AppCompatActivity() {
    lateinit var binding : ActivityListaDePontuacaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDePontuacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        atualizarScores()
    }

    fun atualizarScores(){
        binding.container.removeAllViews()

        val db = Room.databaseBuilder(this, ScoreDatabase::class.java, "scores").build()

        Thread{
            val scores = db.scoreDao().obterTodos()
            val teste = scores.sortedByDescending{ it.pontuacao }

            runOnUiThread{
                for (item in teste){
                    val score = CardScoreBinding.inflate(layoutInflater)

                    score.txtNome.text = item.nome
                    score.txtScore.text = item.pontuacao.toString()

                    binding.container.addView(score.root)
                }
            }
        }.start()
    }
}