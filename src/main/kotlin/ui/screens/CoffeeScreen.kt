package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.CoffeeHouseDB
import ui.components.ClientCardItem
import ui.components.CoffeeCardItem
import kotlin.math.ceil

@Composable
fun CoffeeScreen() {
    val coffeeList by remember { mutableStateOf(CoffeeHouseDB.getCoffee()) }

    val gridColumns = 3
    val gridItemHeight = 117 + 16
    var gridRows = ceil(coffeeList.size.toDouble() / gridColumns).toInt()
    var gridHeight = (gridRows * gridItemHeight).dp

    LaunchedEffect(coffeeList){
        gridRows = ceil(coffeeList.size.toDouble() / gridColumns).toInt()
        gridHeight = (gridRows * gridItemHeight).dp
    }

    LazyColumn {
        item {
            Text(
                text = "Coffee",
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(12.dp)
            )
        }
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(gridColumns),
                modifier = Modifier.height(gridHeight)
            ) {
                items(coffeeList.size) { index ->
                    CoffeeCardItem(
                        coffee = coffeeList[index],
                        onClick = {}
                    )
                }
            }
        }
        item {
            Text(
                text = "Orders",
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}