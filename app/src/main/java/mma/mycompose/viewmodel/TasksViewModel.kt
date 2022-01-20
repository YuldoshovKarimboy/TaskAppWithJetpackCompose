package mma.mycompose.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import mma.mycompose.data.Task

class TasksViewModel : ViewModel() {
    var state = mutableStateListOf<Task>()
        private set

    fun add(task: Task) {
        state.add(task)
        Log.d("TAG", "add: ${state.size}")
    }

    fun remove(task: Task) {
        state.remove(task)
    }
}