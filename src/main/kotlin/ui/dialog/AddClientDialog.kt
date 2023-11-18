package ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text("Имя") }
        )

        OutlinedTextField(
            value = secondName,
            onValueChange = {
                secondName = it
            },
            label = { Text("Фамилия") }
        )

        OutlinedTextField(
            value = mail,
            onValueChange = {
                mail = it
            },
            label = { Text("Почта") }
        )

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            label = { Text("Телефон") }
        )

        OutlinedTextField(
            value = card,
            onValueChange = {
                card = it
            },
            label = { Text("Номер карты") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text("Пароль") }
        )

        Button(
            onClick = {
                CoffeeHouseDB.addClient(Client(
                    id = 0,
                    phone = phone.text,
                    mail = mail.text,
                    card = card.text,
                    name = name.text,
                    secondName = secondName.text,
                    password = password.text
                ))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Добавить")
        }
    }
}

