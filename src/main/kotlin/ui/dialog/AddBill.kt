package ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import data.CoffeeHouseDB
import ui.components.DropDownField
import ui.components.DropDownItem

@Composable
fun AddBill() {
    var billId by remember { mutableStateOf(-1) }
    var clientId by remember { mutableStateOf(-1) }

    val bills by remember { mutableStateOf(
        CoffeeHouseDB.getBills().map { DropDownItem(it.toString(), listOf(it.id, it.clientId)) }) }
    val clients by remember { mutableStateOf(
        CoffeeHouseDB.getClients().map { DropDownItem(it.toString(), listOf(it.id)) }) }

    (bills as ArrayList).add(DropDownItem("New bill"))

    Column {
        DropDownField(
            label = "Bill id",
            items = bills,
            onItemClick = {
                if (it.title != "New bill"){
                    it.content?.let {content->
                        billId = content[0] as Int
                        clientId = content[1] as Int
                    }
                } else {
                    billId = -1
                }
            }
        ) {
            Text(text = it.title)
        }
        DropDownField(
            label = "Client id",
            items = clients,
            value = if (clientId != -1) mutableStateOf("#${clientId}") else mutableStateOf(""),
            onItemClick = {
                it.content?.let {content->
                    clientId = content[0] as Int
                }
            }
        ) {
            Text(text = it.title)
        }
    }
}