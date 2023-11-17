import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddClientScreen() {
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
        TextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            label = { Text("Phone") }
        )

        TextField(
            value = mail,
            onValueChange = {
                mail = it
            },
            label = { Text("Mail") }
        )

        TextField(
            value = card,
            onValueChange = {
                card = it
            },
            label = { Text("Card") }
        )

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text("Name") }
        )

        TextField(
            value = secondName,
            onValueChange = {
                secondName = it
            },
            label = { Text("Second Name") }
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text("Password") }
        )

        Button(
            onClick = {
                val newClient = Client(
                    phone = phone.text,
                    mail = mail.text,
                    card = card.text,
                    name = name.text,
                    secondName = secondName.text,
                    password = password.text
                )
                CoffeeHouseDB.addClient(newClient)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Add Client")
        }
    }
}

