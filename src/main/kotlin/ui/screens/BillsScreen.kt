package ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import data.CoffeeHouseDB
import ui.components.BillItem
import ui.components.TopBillsBar

@Composable
fun BillsScreen() {
    var searchText by remember { mutableStateOf("") }
    var toSort by remember { mutableStateOf(false) }
    val bills = mutableStateOf(CoffeeHouseDB.getAllBillsWithOrders(toSort))
    Scaffold(
        topBar = {
            TopBillsBar(
                searchText = searchText,
                onSortClick = {
                  toSort = !toSort
                },
                onAdd = {

                },
                onSearchTextChanged = { newSearchText ->
                    searchText = newSearchText
                }
            )
        }
    ){
        LazyColumn {
            items(items = bills.value){
                BillItem(it)
            }
        }
    }
}