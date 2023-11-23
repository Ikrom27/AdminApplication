package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.CafeDB
import ui.components.ClientCardItem
import ui.components.TopBillsBar
import ui.dialog.EditClientDialog


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewScreen() {
    var isAddDialogVisible by remember { mutableStateOf(false) }
    var isEditVisible by remember { mutableStateOf(false) }
    var currentIndex by remember { mutableStateOf(0) }

    var searchText by remember { mutableStateOf("") }
    var toSort by remember { mutableStateOf(false) }
    var isDialogVisible by remember { mutableStateOf(false) }

    val item = mutableStateOf(CafeDB.getEvents())

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
        Column {
            // ЗАГОЛОВОК
            Text(
                text = "Заголовок",
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(12.dp)
            )
            // СЕТКА
            LazyVerticalGrid(columns = GridCells.Adaptive(156.dp)) {
                items(item.value.size) { index ->
                    ClientCardItem(
                        events = item.value[index],
                        onClick = {
                            isEditVisible = true
                            currentIndex = index
                        }
                    )
                }
                item {
                    Button(
                        onClick = {isAddDialogVisible = true},
                        colors =  ButtonDefaults.buttonColors(backgroundColor = CoffeeTheme.primary),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(105.dp),
                        shape = RoundedCornerShape(8.dp),
                    ){
                        Text(
                            text = "+",
                            fontSize = 48.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    if (isAddDialogVisible) {
        AlertDialog(
            onDismissRequest = { isAddDialogVisible = false },
            text = {

            },
            buttons = {}
        )
    }
    if (isEditVisible){
        AlertDialog(
            onDismissRequest = { isEditVisible = false },
            text = {
//                EditClientDialog(item.value[currentIndex])
            },
            buttons = {}
        )
    }
}