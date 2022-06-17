package com.example.appmobilequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmobilequiz.databinding.ActivityMainBinding
import com.example.appmobilequiz.databinding.ActivitySobreBinding
import com.example.appmobilequiz.databinding.ActivityTelaDeLoginBinding

class Sobre : AppCompatActivity() {
    lateinit var binding : ActivitySobreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu.setOnClickListener{
            finish()
        }
    }
}