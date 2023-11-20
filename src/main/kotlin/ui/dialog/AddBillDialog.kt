package ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import data.CoffeeHouseDB
import ui.components.DropDownField
import ui.components.DropDownItem

@Composable
fun AddBillDialog(
    onClick: () -> Unit
) {
    var billId by remember { mutableStateOf(-1) }
    var clientId by remember { mutableStateOf(-1) }
    var coffeeId by remember { mutableStateOf(-1) }

    val billList by remember { mutableStateOf(
        CoffeeHouseDB.getBills().map { DropDownItem("#${it.id}", listOf(it.id, it.clientId)) }) }
    val clientList by remember { mutableStateOf(
        CoffeeHouseDB.getClients().map { DropDownItem("#${it.id} ${it.name} ${it.secondName}", listOf(it.id)) }) }
    val coffeeList by remember { mutableStateOf(
        CoffeeHouseDB.getCoffee().map { DropDownItem("${it.name}", listOf(it.id)) }) }

    (billList as ArrayList).add(DropDownItem("New bill"))

    Column {
        DropDownField(
            label = "Coffee",
            items = coffeeList,
            onItemClick = {
                it.content?.let {content->
                    coffeeId = content[0] as Int
                }
            }
        ) {
            Text(text = it.title)
        }
        DropDownField(
            label = "Bill id",
            items = billList,
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
            items = clientList,
            value = if (clientId != -1) mutableStateOf("#${clientId}") else mutableStateOf(""),
            onItemClick = {
                it.content?.let {content->
                    clientId = content[0] as Int
                }
            }
        ) {
            Text(text = it.title)
        }

        Button(
            onClick = {
                CoffeeHouseDB.addCoffeeToBill(coffeeId,  billId, clientId)
                onClick()
            }
        ) {
            Text("Add")
        }
    }
}