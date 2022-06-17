package com.example.appmobilequiz

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Score::class), version = 1)
abstract class ScoreDatabase : RoomDatabase(){
    abstract fun scoreDao(): ScoreDao
}