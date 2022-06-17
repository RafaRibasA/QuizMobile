package com.example.appmobilequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmobilequiz.databinding.FragmentQuestao1Binding

class Questao1 : Fragment() {
    lateinit var binding : FragmentQuestao1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuestao1Binding.inflate(layoutInflater)
        return binding.root
    }

    fun verifierAlternative() : String{
        var idRb = binding.rgAlternativas1.checkedRadioButtonId

        var resposta = ""

        resposta = if(idRb == binding.rbAlternativa11.id) "CERTO"
        else "ERRADO"

        return resposta
    }

    fun eliminarAlternativa(){
        binding.rgAlternativas1.clearCheck()

        binding.rbAlternativa13.isEnabled = false
        binding.rbAlternativa15.isEnabled = false
    }
}