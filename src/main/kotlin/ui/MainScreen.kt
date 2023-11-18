package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.screens.ClientsScreen

@Composable
fun MainScreen() {
    var columnWidth by remember { mutableStateOf(0.1f) }
    Row{
        Column(
            modifier = Modifier
                .width(256.dp)
                .background(Color(247, 247, 245))
        ) {
            DrawerContent()
        }
        Column {
            ClientsScreen()
        }
    }
}

@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Drawer Content", modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))

        Text("item 1")
        Text("item 2")
        Text("item 3")
    }
}