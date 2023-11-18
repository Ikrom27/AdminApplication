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