package ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import data.CoffeeHouseDB
import ui.components.BillItem
import ui.components.TopBillsBar

@Composable
fun BillsScreen() {
    var searchText by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopBillsBar(
                searchText = searchText,
                onSearchTextChanged = { newSearchText ->
                    searchText = newSearchText
                }
            )
        }
    ){

    }
}