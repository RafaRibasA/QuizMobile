package com.example.appmobilequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmobilequiz.databinding.FragmentQuestao4Binding

class Questao4 : Fragment() {
    lateinit var binding : FragmentQuestao4Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuestao4Binding.inflate(layoutInflater)
        return binding.root
    }

    fun verificarAlternativa() : String{
        var idRb = binding.rgAlternativas4.checkedRadioButtonId

        var resposta = ""

        resposta = if(idRb == binding.rbAlternativa42.id) "CERTO"
        else "ERRADO"

        return resposta
    }

    fun eliminarAlternativa(){
        binding.rgAlternativas4.clearCheck()

        binding.rbAlternativa41.isEnabled = false
        binding.rbAlternativa44.isEnabled = false
    }

}