package com.example.todo.repository

import com.example.todo.db.DatabaseProvider
import com.example.todo.db.TasksDao
import com.example.todo.models.Task

class TaskRepository {
    private val dao: TasksDao = DatabaseProvider.db.getTasksDao()

    suspend fun addTask(task: Task) {
        dao.insert(task)
    }

    suspend fun getAllTasks(): List<Task> {
        return dao.getAll()
    }
}