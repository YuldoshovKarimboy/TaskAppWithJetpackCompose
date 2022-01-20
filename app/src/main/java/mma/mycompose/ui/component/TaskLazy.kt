package mma.mycompose.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mma.mycompose.data.Task

@Composable
fun TaskLazy(state: SnapshotStateList<Task>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(state) { task ->
            TaskLazyItem(
                onApplyTask = {
                    state[state.indexOf(task)] = it
                },
                onRemoveTask = {
                    state.remove(it)
                },
                task = task
            )
        }
    }
}

@Composable
fun TaskLazyItem(
    onApplyTask: (Task) -> Unit,
    onRemoveTask: (Task) -> Unit,
    task: Task
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    OutlinedButton(onClick = {
        expanded = !expanded
    }) {
        if (expanded) {
            EditTaskLayout(isEdit = true,
                task = task,
                onAddTask = {},
                onApplyTask = {
                    onApplyTask(it)
                    expanded = !expanded
                }, onRemoveTask = {
                    onRemoveTask(it)
                    expanded = !expanded
                })
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = task.task, modifier = Modifier.weight(1f))
                Icon(
                    imageVector = task.icon.imageVector,
                    contentDescription = stringResource(id = task.icon.contentDescription),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }

}
