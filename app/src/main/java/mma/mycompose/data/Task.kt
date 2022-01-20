package mma.mycompose.data

import java.util.*

data class Task(
    val task: String = "",
    val icon: TaskIcon = TaskIcon.Default,
    val uid: UUID = UUID.randomUUID()
)
