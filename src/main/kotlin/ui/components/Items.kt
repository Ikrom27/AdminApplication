package ui.components

import CoffeeTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.BillWithOrders
import data.Client


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientCardItem(client: Client, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(105.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        backgroundColor = CoffeeTheme.secondary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "${client.name}",
                style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${client.mail}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 12.sp
                )
            )
//            Text(
//                text = "${client.password}",
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                style = MaterialTheme.typography.body2.copy(
//                    fontSize = 12.sp
//                )
//            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${client.averageTotal}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6)
        }
    }
}

@Composable
fun BillItem(bill: BillWithOrders){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = CoffeeTheme.secondary
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                Modifier.weight(0.6f)
            ) {
                Text(
                    text = "#${bill.bill.id}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "#${bill.client.id} ${bill.client.name} ${bill.client.secondName}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2.copy(
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    text = "${bill.bill.date.toLocalDate()}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2.copy(
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    text = "Total $${bill.bill.total}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 14.dp)
                )
            }
            Column(Modifier.weight(0.4f)) {
                Text(
                    text = "Details",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                for(i in bill.orderList){
                    Text(
                        text = "${i.title} x${i.count}",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}


@Composable
fun DrawerItem(
    title: String,
    selected: String,
    onClick: () -> Unit
){
    var bgColor = CoffeeTheme.backgroundSecondary
    if (selected == title){
        bgColor = CoffeeTheme.secondary
    }

    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = bgColor,
        elevation = 0.dp,
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
    ){
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}


@Composable
fun DropDownField(
    label: String,
    items: List<DropDownItem>,
    onItemClick: (DropDownItem) -> Unit,
    value: MutableState<String> = remember { mutableStateOf("") },
    content: @Composable (DropDownItem) -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(-1) }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                value = value.value,
                onValueChange = {
                    value.value = it
                    selectedIndex = -1
                },
                label = { Text(label)},
                textStyle = MaterialTheme.typography.body1.copy(fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        expanded = true
                    }
            )

            IconButton(
                onClick = {
                    expanded = !expanded
                },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Expand"
                )
            }
        }

        DropdownMenu(
            expanded = expanded && items.isNotEmpty(),
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .graphicsLayer(
                    translationY = with(LocalDensity.current) { (-8.dp * selectedIndex).toPx() }
                )
        ) {
            items.forEachIndexed { _, option ->
                DropdownMenuItem(
                    onClick = {
                        onItemClick(option)
                        value.value = option.title
                        expanded = false
                    }
                ) {
                    content(option)
                }
            }
        }
    }
}


class DropDownItem(
    val title: String,
    val content: List<Any>? = null
)