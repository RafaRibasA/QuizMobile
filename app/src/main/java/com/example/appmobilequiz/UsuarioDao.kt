package com.example.appmobilequiz

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Insert
    fun inserirUser(user: User)

    @Query("SELECT * FROM User")
    fun obterTodosUsers(): List<User>
}