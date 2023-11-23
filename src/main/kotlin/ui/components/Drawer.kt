package ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DrawerContent(
    selected: String,
    onSelectionChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 22.dp)
    ) {
        DrawerItem("Новости", selected) {
            onSelectionChange("Новости")
        }
        DrawerItem("Клиенты", selected) {
            onSelectionChange("Клиенты")
        }
        DrawerItem("Организаторы", selected) {
            onSelectionChange("Организаторы")
        }
        DrawerItem("Мероприятия", selected) {
            onSelectionChange("Мероприятия")
        }
        DrawerItem("Инфо", selected) {
            onSelectionChange("Инфо")
        }
    }
}