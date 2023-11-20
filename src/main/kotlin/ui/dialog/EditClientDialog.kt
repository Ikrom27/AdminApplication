package ui.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import data.Client
import data.CoffeeHouseDB

@Composable
fun EditClientDialog(client: Client) {
    var phone by remember { mutableStateOf(TextFieldValue(client.phone)) }
    var mail by remember { mutableStateOf(TextFieldValue(client.mail)) }
    var card by remember { mutableStateOf(TextFieldValue(client.card)) }
    var name by remember { mutableStateOf(TextFieldValue(client.name)) }
    var secondName by remember { mutableStateOf(TextFieldValue(client.secondName)) }
    var password by remember { mutableStateOf(TextFieldValue(client.password)) }
    var errorText by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text("Имя") },
            modifier = Modifier
                .width(256.dp)
        )

        OutlinedTextField(
            value = secondName,
            onValueChange = {
                secondName = it
            },
            label = { Text("Фамилия") },
            modifier = Modifier
                .width(256.dp)
        )

        OutlinedTextField(
            value = mail,
            onValueChange = {
                mail = it
            },
            label = { Text("Почта") },
            modifier = Modifier
                .width(256.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            label = { Text("Телефон") },
            modifier = Modifier
                .width(256.dp)
        )

        OutlinedTextField(
            value = card,
            onValueChange = {
                card = it
            },
            label = { Text("Номер карты") },
            modifier = Modifier
                .width(256.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            maxLines = 1,
            singleLine = true,
            label = { Text("Пароль") },
            modifier = Modifier
                .width(256.dp)
        )

        if (errorText != ""){
            Text(
                text = errorText,
                color = MaterialTheme.colors.error
            )
        }
        Button(
            onClick = {
                try {
                    CoffeeHouseDB.updateClient(
                        Client(
                        id = client.id,
                        phone = phone.text,
                        mail = mail.text,
                        card = card.text,
                        name = name.text,
                        secondName = secondName.text,
                        password = password.text
                    )
                    )
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

        Button(
            onClick = {
                try {
                    CoffeeHouseDB.deleteClient(client.id)
                } catch (e: Exception) {
                    errorText = "${e.message}"
                }
            },
            colors =  ButtonDefaults.buttonColors(backgroundColor = Color(240, 240, 240)),
            modifier = Modifier
                .width(256.dp)
                .padding(top = 4.dp)
        ) {
            Text("Delete", color = Color.Red)
        }
    }
}