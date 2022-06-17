package com.example.appmobilequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmobilequiz.databinding.FragmentQuestao2Binding

class Questao2 : Fragment() {
    lateinit var binding : FragmentQuestao2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuestao2Binding.inflate(layoutInflater)
        return binding.root
    }

    fun verificarAlternativa() : String{
        var idRb = binding.rgAlternativas2.checkedRadioButtonId

        var resposta = ""

        resposta = if(idRb == binding.rbAlternativa23.id) "CERTO"
        else "ERRADO"

        return resposta
    }

    fun eliminarAlternativa(){
        binding.rgAlternativas2.clearCheck()

        binding.rbAlternativa24.isEnabled = false
        binding.rbAlternativa25.isEnabled = false
    }
}