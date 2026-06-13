package com.example.labo5

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labo5.data.entities.Task
import com.example.labo5.remote.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GeneralViewModel : ViewModel() {
    private val repository = TaskRepository(InitDatabase.database.taskDao())

    val tasks: StateFlow<List<Task>> = repository.allTasks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.insert(task)
        }
    }
}