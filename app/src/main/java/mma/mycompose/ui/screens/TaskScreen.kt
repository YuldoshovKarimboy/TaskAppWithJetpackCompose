package mma.mycompose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import mma.mycompose.ui.component.EditTaskLayout
import mma.mycompose.ui.component.TaskLazy
import mma.mycompose.viewmodel.TasksViewModel

@Composable
fun TaskScreen(viewModel: TasksViewModel) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (taskAppBar, taskLazy) = createRefs()
        EditTaskLayout(modifier = Modifier.constrainAs(taskAppBar) {
            top.linkTo(parent.top)
        }, onAddTask = { task ->
            viewModel.add(task)
        }, onApplyTask = {}, onRemoveTask = {})
        TaskLazy(state = viewModel.state, modifier = Modifier.constrainAs(taskLazy) {
            top.linkTo(taskAppBar.bottom)
        })
    }
}