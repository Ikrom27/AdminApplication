package ui.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.CoffeeHouseDB
import ui.components.ClientCard
import ui.dialog.AddClientDialog


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientsScreen() {
    var isAddUserDialogVisible by remember { mutableStateOf(false) }

    val clients = mutableStateOf(CoffeeHouseDB.getClients())

    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(clients.value.size) { index ->
            ClientCard(client = clients.value[index])
        }
        item {
            Button(
                onClick = {isAddUserDialogVisible = true},
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                shape = RoundedCornerShape(8.dp)
            ){
                Text(text = "\n\n+ добавить пользователя\n")
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
}