package com.example.appmobilequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.appmobilequiz.databinding.ActivityTelaDeQuestoesBinding

class TelaDeQuestoes : AppCompatActivity() {
    lateinit var binding: ActivityTelaDeQuestoesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeQuestoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var questaoAtual = 1
        var score = 0

        val fragmentoQuestao1 = Questao1()
        val fragmentoQuestao2 = Questao2()
        val fragmentoQuestao3 = Questao3()
        val fragmentoQuestao4 = Questao4()
        val fragmentoQuestao5 = Questao5()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao1).commit()

        binding.btnProximo.setOnClickListener {
            var resposta = ""

            if(questaoAtual == 1) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao2).commit()
                resposta = fragmentoQuestao1.verifierAlternative()
            }

            if(questaoAtual == 2) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao3).commit()
                resposta = fragmentoQuestao2.verificarAlternativa()
            }

            if(questaoAtual == 3){
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao4).commit()
                resposta = fragmentoQuestao3.verificarAlternativa()
            }

            if(questaoAtual == 4){
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao5).commit()
                resposta = fragmentoQuestao4.verificarAlternativa()
            }

            if(questaoAtual == 5){
                resposta = fragmentoQuestao5.verificarAlternativa()
            }

            //alert("Teste", "A resposta está " + resposta, this)

            if(resposta == "CERTO"){
                score = score + 100
            }

            if(questaoAtual == 5){
                val i = Intent(this, TelaDePontuacao::class.java)
                i.putExtra("score", score)
                startActivity(i)
            }

            questaoAtual++
        }

        binding.btnPular.setOnClickListener{
            if(questaoAtual == 1) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao2).commit()
            }

            if(questaoAtual == 2) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao3).commit()
            }

            if(questaoAtual == 3){
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao4).commit()
            }

            if(questaoAtual == 4){
                supportFragmentManager.beginTransaction().replace(R.id.fragmentoQuestoes, fragmentoQuestao5).commit()
            }

            if(questaoAtual == 5){
                val i = Intent(this, TelaDePontuacao::class.java)
                i.putExtra("score", score)
                startActivity(i)
            }

            binding.btnPular.isEnabled = false
            score = score + 100
            questaoAtual++
        }

        binding.btnEliminar.setOnClickListener{
            if(questaoAtual == 1) {
                fragmentoQuestao1.eliminarAlternativa()
            }

            if(questaoAtual == 2) {
                fragmentoQuestao2.eliminarAlternativa()
            }

            if(questaoAtual == 3){
                fragmentoQuestao3.eliminarAlternativa()
            }

            if(questaoAtual == 4){
                fragmentoQuestao4.eliminarAlternativa()
            }

            if(questaoAtual == 5){
                fragmentoQuestao5.eliminarAlternativa()
            }

            binding.btnEliminar.isEnabled = false

        }

        binding.btnDesistir.setOnClickListener{
            alertDesistir("DESISTIR", "CERTEZA QUE QUER DESISTIR?", score)
        }

        binding.btnDica.setOnClickListener{
            if(questaoAtual == 1) {
                alert("Dica Questão 1", "Foi um filme solo de um dos principais heróis dos vingadores originais",this)
            }

            if(questaoAtual == 2) {
                alert("Dica Questão 2", "Foi um filme que se passa depois do grande clímax da 3º fase",this)
            }

            if(questaoAtual == 3){
                alert("Dica Questão 3", "O tesseract era capaz de fornecer acesso instantaneo para qualquer lugar do universo",this)
            }

            if(questaoAtual == 4){
                alert("Dica Questão 4", "Ele foi um cientista brilhante no Universo Cinematográfico da Marvel",this)
            }

            if(questaoAtual == 5){
                alert("Dica Questão 5", " É o material do qual o escudo do capitão américa foi feito",this)
            }
            binding.btnDica.isEnabled = false

        }

    }

    fun alertDesistir(title: String, msg: String, score: Int) {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("SIM"){dialog,
                                      which ->
                val i = Intent(this, TelaDePontuacao::class.java)
                i.putExtra("score", score)
                startActivity(i)
            }
            .setNegativeButton("NÃO", null)
            .create()
            .show()
    }
}