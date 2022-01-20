package mma.mycompose.util

import mma.mycompose.data.Task
import mma.mycompose.data.TaskIcon

fun generateRandomTask(): Task {
    val message = listOf(
        "Learn Compose",
        "Learn state",
        "Build dynamic UIs",
        "Learn Unidirectional Data Flow",
        "Integrate LiveData",
        "Integrate ViewModel",
        "Remember to savedState",
        "Build stateless composables",
        "Use state from stateless composables"
    ).random()
    val icon = TaskIcon.values().random()
    return Task(message, icon)
}