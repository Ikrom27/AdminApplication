package ui.screens

import CoffeeTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import data.CafeDB
import ui.components.BillItem
import ui.components.TopBillsBar
import ui.dialog.AddBillDialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BillsScreen() {
    var searchText by remember { mutableStateOf("") }
    var toSort by remember { mutableStateOf(false) }
    var isDialogVisible by remember { mutableStateOf(false) }

    var bills by remember { mutableStateOf(CafeDB.getAllBillsWithOrders(toSort, searchText)) }

    LaunchedEffect(searchText, toSort) {
        bills = CafeDB.getAllBillsWithOrders(toSort, searchText)
    }

    Scaffold(
        topBar = {
            TopBillsBar(
                searchText = searchText,
                onSortClick = {
                  toSort = !toSort
                },
                onAdd = {
                    isDialogVisible = true
                },
                onSearchTextChanged = { newSearchText ->
                    searchText = newSearchText
                }
            )
        },
        backgroundColor = CoffeeTheme.background
    ){
        // Контент
        LazyColumn {
            items(items = bills){
                BillItem(it)
            }
        }
    }

    if (isDialogVisible){
        AlertDialog(
            onDismissRequest = { isDialogVisible = false },
            text = {
                AddBillDialog(
                    onClick = {
                        isDialogVisible = false
                    }
                )
            },
            buttons = {}
        )
    }
}