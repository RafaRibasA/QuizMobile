package com.example.appmobilequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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
            if (binding.edNoneScore.text.toString().isEmpty()){
                alert("Sem nome","Para salvar sua pontuação deve colocar um nome antes.", this)
            }
            else{
                val score = Score(
                    nome = binding.edNoneScore.text.toString(),
                    pontuacao = pontuacao
                )

                Thread{
                    db.scoreDao().inserir(score)
                    voltarParaOMenu()
                }.start()
            }
        }

        binding.btnVoltarMenu.setOnClickListener{
            alertDesistir("Certeza?", "Se você voltar para o menu sua pontuação será perdida, tem certeza que não quer salvar?")
        }
    }

    fun voltarParaOMenu(){
        finishAffinity()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }


    fun alertDesistir(title: String, msg: String) {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("SIM"){dialog, which ->
                voltarParaOMenu()
            }
            .setNegativeButton("NÃO", null)
            .create()
            .show()
    }
}