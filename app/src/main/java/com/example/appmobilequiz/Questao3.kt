package com.example.appmobilequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmobilequiz.databinding.FragmentQuestao3Binding

class Questao3 : Fragment() {
    lateinit var binding : FragmentQuestao3Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuestao3Binding.inflate(layoutInflater)
        return binding.root
    }

    fun verificarAlternativa() : String{
        var idRb = binding.rgAlternativas3.checkedRadioButtonId

        var resposta = ""

        resposta = if(idRb == binding.rbAlternativa34.id) "CERTO"
        else "ERRADO"

        return resposta
    }

    fun eliminarAlternativa(){
        binding.rgAlternativas3.clearCheck()

        binding.rbAlternativa32.isEnabled = false
        binding.rbAlternativa35.isEnabled = false
    }
}