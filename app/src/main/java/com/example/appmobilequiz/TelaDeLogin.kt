package com.example.appmobilequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmobilequiz.databinding.ActivityTelaDeLoginBinding

class TelaDeLogin : AppCompatActivity() {
    lateinit var binding : ActivityTelaDeLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}