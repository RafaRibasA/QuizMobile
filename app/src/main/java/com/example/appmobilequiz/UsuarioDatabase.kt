package com.example.appmobilequiz

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class UsuarioDatabase : RoomDatabase(){
    abstract fun usuarioDao() : UsuarioDao
}