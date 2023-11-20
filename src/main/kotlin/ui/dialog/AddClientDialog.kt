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
fun AddClientDialog() {
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var mail by remember { mutableStateOf(TextFieldValue("")) }
    var card by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var secondName by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var errorText by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
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
                    CoffeeHouseDB.addClient(Client(
                        id = 0,
                        phone = phone.text,
                        mail = mail.text,
                        card = card.text,
                        name = name.text,
                        secondName = secondName.text,
                        password = password.text
                    ))
                } catch (e: Exception) {
                    errorText = "${e.message}"
                }
            },
            colors =  ButtonDefaults.buttonColors(backgroundColor = CoffeeTheme.primary),
            modifier = Modifier
                .width(256.dp)
                .padding(top = 16.dp)
        ) {
            Text("Добавить", color = Color.White)
        }
    }
}

