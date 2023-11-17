package ui

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import ui.dialog.AddClientDialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {

    var isAddUserDialogVisible by remember { mutableStateOf(false) }
    Button(
        onClick = {
            isAddUserDialogVisible = true
        }
    ){
        Text("Добавить пользователя")
    }
    if (isAddUserDialogVisible) {
        AlertDialog(
            onDismissRequest = { isAddUserDialogVisible = false },
            text = {
                AddClientDialog()
            },
            buttons = {}
        )
    }
}