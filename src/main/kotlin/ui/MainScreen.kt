package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.components.DrawerItem
import ui.screens.BillsScreen
import ui.screens.ClientsScreen
import ui.screens.CoffeeScreen

@Composable
fun MainScreen() {
    var selected by remember { mutableStateOf("Clients") }

    Row{
        Column(
            modifier = Modifier
                .width(192.dp)
                .background(Color(247, 247, 245))
        ) {
            DrawerContent(selected) { newSelection ->
                selected = newSelection
            }
        }
        Column(modifier = Modifier.padding(14.dp)) {
            when(selected) {
                "Clients" -> ClientsScreen()
                "Bills" -> BillsScreen()
                "Coffee" -> CoffeeScreen()
            }
        }
    }
}

@Composable
fun DrawerContent(
    selected: String,
    onSelectionChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DrawerItem("Clients", selected) {
            onSelectionChange("Clients")
        }
        DrawerItem("Bills", selected) {
            onSelectionChange("Bills")
        }
        DrawerItem("Coffee", selected) {
            onSelectionChange("Coffee")
        }
    }
}