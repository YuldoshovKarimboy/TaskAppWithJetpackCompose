package mma.mycompose.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mma.mycompose.data.TaskIcon

@Composable
fun IconTableRow(
    onChangeIcon: (TaskIcon) -> Unit,
    taskIcon: TaskIcon = TaskIcon.Default
) {
    var taskIcon by remember {
        mutableStateOf(taskIcon)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        for (icon in TaskIcon.values())
            IconRow(
                taskIcon = icon,
                modifier = Modifier.weight(1f, true),
                isSelect = taskIcon == icon,
                onSelect = {
                    onChangeIcon(icon)
                    taskIcon = icon
                })
    }
}

@Composable
fun IconRow(
    taskIcon: TaskIcon,
    modifier: Modifier,
    isSelect: Boolean,
    onSelect: () -> Unit
) {
    val tint = if (isSelect) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
    IconButton(onClick = {
        onSelect()
    }, modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Icon(
                imageVector = taskIcon.imageVector, contentDescription = stringResource(
                    id = taskIcon.contentDescription
                ), tint = tint
            )
            Text(
                text = stringResource(id = taskIcon.contentDescription),
                modifier = Modifier.padding(top = 2.dp), color = tint, fontSize = 12.sp
            )
        }
    }
}
