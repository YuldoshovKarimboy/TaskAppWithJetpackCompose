package mma.mycompose.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import mma.mycompose.data.Task

@Composable
fun EditTaskLayout(
    modifier: Modifier=Modifier,
    task: Task = Task(),
    isEdit: Boolean =false,
    onAddTask: (Task) -> Unit,
    onApplyTask: (Task) -> Unit,
    onRemoveTask: (Task) -> Unit
) {
    var taskIcon by remember {
        mutableStateOf(task.icon)
    }
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditTextLayout(
            text = task.task,
            isEdit = isEdit,
            onAddText = { onAddTask(Task(it, taskIcon)) },
            onApplyText = { onApplyTask(Task(it, taskIcon)) },
            onRemoveText = { onRemoveTask(task) })
        IconTableRow(
            onChangeIcon = { taskIcon = it },
            taskIcon = taskIcon
        )
    }
}