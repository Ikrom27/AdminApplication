package ui.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import data.CoffeeHouseDB
import ui.components.ClientCardItem
import ui.components.CoffeeCardItem

@Composable
fun CoffeeScreen() {
    val coffeeList by remember { mutableStateOf(CoffeeHouseDB.getCoffee()) }

    LazyVerticalGrid(columns = GridCells.Adaptive(156.dp)) {
        items(coffeeList.size) { index ->
            CoffeeCardItem(
                coffee = coffeeList[index],
                onClick = {}
            )
        }
    }
}