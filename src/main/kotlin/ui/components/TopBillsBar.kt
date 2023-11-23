package ui.components

import CoffeeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

@Composable
fun TopBillsBar(
    searchText: String,
    onSortClick: () -> Unit,
    onAdd: () -> Unit,
    onSearchTextChanged: (String) -> Unit
) {
    var isSortActive by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 4.dp)
            .clip(MaterialTheme.shapes.medium)
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                onSearchTextChanged(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = MaterialTheme.colors.onSecondary,
                    contentDescription = "",
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = CoffeeTheme.secondary,
                unfocusedLabelColor = MaterialTheme.colors.onBackground,
                focusedLabelColor = MaterialTheme.colors.onBackground,
                cursorColor = MaterialTheme.colors.onBackground,
                textColor = MaterialTheme.colors.onBackground,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                onSortClick()
                isSortActive = !isSortActive
            }
        ){
            Icon(
                painter = painterResource("sort.svg"),
                contentDescription = "Sort",
                modifier = Modifier.size(42.dp).padding(start = 8.dp, top = 6.dp),
                tint = if(isSortActive) CoffeeTheme.primary else CoffeeTheme.secondary
            )
        }

        // Кнопка добавления
        IconButton(
            onClick = {
                onAdd()
            },
            modifier = Modifier.padding(start = 8.dp)
        ){
            Icon(
                painter = painterResource("add.svg"),
                contentDescription = "Add",
                modifier = Modifier.size(28.dp),
                tint = CoffeeTheme.secondary
            )
        }
    }
}