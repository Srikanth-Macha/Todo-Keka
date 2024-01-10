package com.example.todo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todo.models.Category
import com.example.todo.models.Priority
import com.example.todo.models.Task
import com.google.gson.Gson

@Database(entities = [Task::class], version = 1)
@TypeConverters(PriorityTypeConverter::class, CategoryTypeConverter::class)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun getTasksDao(): TasksDao
}


object PriorityTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun toJson(priority: Priority): String {
        return gson.toJson(priority).toString()
    }

    @TypeConverter
    fun fromJson(json: String): Priority {
        return gson.fromJson(json, Priority::class.java)
    }
}

@TypeConverters
object CategoryTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun toJson(category: Category): String {
        return gson.toJson(category).toString()
    }

    @TypeConverter
    fun fromJson(json: String): Category {
        return gson.fromJson(json, Category::class.java)
    }
}

