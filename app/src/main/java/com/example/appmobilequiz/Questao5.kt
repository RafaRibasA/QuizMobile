package com.example.appmobilequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmobilequiz.databinding.FragmentQuestao4Binding
import com.example.appmobilequiz.databinding.FragmentQuestao5Binding

class Questao5 : Fragment() {
    lateinit var binding : FragmentQuestao5Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestao5Binding.inflate(layoutInflater)
        return binding.root
    }

    fun verificarAlternativa() : String{
        var idRb = binding.rgAlternativas5.checkedRadioButtonId

        var resposta = ""

        resposta = if(idRb == binding.rbAlternativa55.id) "CERTO"
        else "ERRADO"

        return resposta
    }

    fun eliminarAlternativa(){
        binding.rgAlternativas5.clearCheck()

        binding.rbAlternativa52.isEnabled = false
        binding.rbAlternativa53.isEnabled = false
    }

}