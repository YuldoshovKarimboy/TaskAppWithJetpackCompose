package mma.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import mma.mycompose.ui.screens.TaskScreen
import mma.mycompose.viewmodel.TasksViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<TasksViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskScreen(viewModel = viewModel)
        }
    }
}
