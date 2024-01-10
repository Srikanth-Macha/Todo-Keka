package com.example.todo.db

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    lateinit var db: TasksDatabase

    fun createDatabase(context: Context) {
        db = Room.databaseBuilder(context, TasksDatabase::class.java, "tasks").build()
    }
}