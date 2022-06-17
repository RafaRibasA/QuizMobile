package com.example.appmobilequiz

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {
    @Insert
    fun inserir(score: Score)

    @Query("SELECT * FROM Score")
    fun obterTodos(): List<Score>
}