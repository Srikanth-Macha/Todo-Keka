package com.example.todo.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.models.Task
import com.example.todo.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {
    private val taskRepository = TaskRepository()

    val allTasksState = MutableStateFlow(emptyList<Task>())

    init {
        getAllTasks()
    }

    fun addTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.addTask(task)
        }
    }

    fun getAllTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val allTasks = taskRepository.getAllTasks()

            allTasksState.update { allTasks }
        }
    }
}