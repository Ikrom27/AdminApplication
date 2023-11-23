package ui.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.Client
import data.Events

@Composable
fun EditClientDialog(client: Client) {
    var mail by remember { mutableStateOf("${client.mail}") }
    var errorText by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        OutlinedTextField(
            value = mail,
            onValueChange = {
                mail = it
            },
            label = { Text("Почта") },
            modifier = Modifier
                .width(256.dp)
        )

        if (errorText != ""){
            Text(
                text = errorText,
                color = MaterialTheme.colors.error
            )
        }

        // КНОПКА ОБНОВЛЕНИЯ
        Button(
            onClick = {
                try {

                } catch (e: Exception) {
                    errorText = "${e.message}"
                }
            },
            colors =  ButtonDefaults.buttonColors(backgroundColor = CoffeeTheme.primary),
            modifier = Modifier
                .width(256.dp)
                .padding(top = 12.dp)
        ) {
            Text("Update", color = Color.White)
        }

        // КНОПКА УДАЛЕНИЯ
        Button(
            onClick = {
                try {

                } catch (e: Exception) {
                    errorText = "${e.message}"
                }
            },
            colors =  ButtonDefaults.buttonColors(backgroundColor = CoffeeTheme.backgroundSecondary),
            modifier = Modifier
                .width(256.dp)
                .padding(top = 4.dp)
        ) {
            Text("Delete", color = Color.Red)
        }
    }
}