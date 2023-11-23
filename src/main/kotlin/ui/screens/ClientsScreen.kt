package ui.screens

import CoffeeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.CafeDB
import ui.components.ClientCardItem
import ui.dialog.AddClientDialog
import ui.dialog.EditClientDialog


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientsScreen() {
    var isAddUserDialogVisible by remember { mutableStateOf(false) }
    var isEditClientVisible by remember { mutableStateOf(false) }
    var currentClientId by remember { mutableStateOf(0) }

    val clients = mutableStateOf(CafeDB.getClients())
    Column {
        Text(
            text = "Clients",
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(12.dp)
        )
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
                    colors =  ButtonDefaults.buttonColors(backgroundColor = CoffeeTheme.primary),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(105.dp),
                    shape = RoundedCornerShape(8.dp),
                ){
                    Text(
                        text = "+",
                        fontSize = 48.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
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