package com.example.appmobilequiz

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null,
    var nome: String,
    var pontuacao : Int
)
