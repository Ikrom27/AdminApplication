package ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import data.CoffeeHouseDB
import ui.components.BillItem

@Composable
fun BillsScreen() {
    val bills = mutableStateOf(CoffeeHouseDB.getAllBillsWithOrders())
    LazyColumn {
        items(items = bills.value){
            BillItem(it)
        }
    }
}