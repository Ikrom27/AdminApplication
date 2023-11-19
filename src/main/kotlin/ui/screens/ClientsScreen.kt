package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.CoffeeHouseDB
import ui.components.ClientCardItem
import ui.components.TopBillsBar
import ui.dialog.AddClientDialog
import ui.dialog.EditClientDialog


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientsScreen() {
    var isAddUserDialogVisible by remember { mutableStateOf(false) }
    var isEditClientVisible by remember { mutableStateOf(false) }
    var currentClientId by remember { mutableStateOf(0) }

    val clients = mutableStateOf(CoffeeHouseDB.getClients())

    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(clients.value.size) { index ->
            ClientCardItem(
                client = clients.value[index],
                onClick = {
                    isEditClientVisible = true
                    currentClientId = index
                }
            )
        }
        item {
            Button(
                onClick = {isAddUserDialogVisible = true},
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(105.dp),
                shape = RoundedCornerShape(8.dp)
            ){
                Text(
                    text = "+ добавить пользователя",
                    textAlign = TextAlign.Center
                )
            }
        }
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
    if (isEditClientVisible){
        AlertDialog(
            onDismissRequest = { isEditClientVisible = false },
            text = {
                EditClientDialog(clients.value[currentClientId])
            },
            buttons = {}
        )
    }
}