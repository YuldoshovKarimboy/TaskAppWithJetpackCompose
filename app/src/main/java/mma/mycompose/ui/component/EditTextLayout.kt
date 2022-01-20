package mma.mycompose.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun EditTextLayout(
    text: String = "",
    isEdit: Boolean = false,
    onAddText: (String) -> Unit,
    onApplyText: (String) -> Unit,
    onRemoveText: () -> Unit
) {
    var text by remember {
        mutableStateOf(text)
    }
    var status by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.weight(1f),
            label = { Text(text = "Enter body") },
            singleLine = true,
            placeholder = { Text(text = "Typing...") }
        )
        Button(
            onClick = {
                when (status) {
                    "Add" -> {
                        onAddText(text)
                    }
                    "Apply" -> {
                        onApplyText(text)
                    }
                    "Remove" -> {
                        onRemoveText()
                    }
                }
                text = ""
            }, modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
        ) {
            status = if (isEdit) {
                if (text.isEmpty()) {
                    Text(text = "Remove")
                    "Remove"
                } else {
                    Text(text = "Apply")
                    "Apply"
                }
            } else {
                Text(text = "Add")
                "Add"
            }
        }
    }
}