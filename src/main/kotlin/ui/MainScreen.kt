package ui

import CoffeeTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.DrawerContent
import ui.screens.NewScreen

@Composable
fun MainScreen() {
    var selected by remember { mutableStateOf("Clients") }

    Row(
        modifier = Modifier.background(CoffeeTheme.background)
    ){
        Column(
            modifier = Modifier
                .width(192.dp)
                .background(CoffeeTheme.backgroundSecondary)
        ) {
            DrawerContent(selected) { newSelection ->
                selected = newSelection
            }
        }
        //Новые экраны будут появляться справа
        Column(modifier = Modifier.padding(14.dp)) {
            when(selected) {
                "New" -> NewScreen()
            }
        }
    }
}