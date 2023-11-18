package ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.BillWithOrders
import data.Client


@Composable
fun ClientCardItem(client: Client) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(105.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(220, 210, 242)
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
        backgroundColor = Color(220, 210, 242)
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
                    text = "${bill.client.name} ${bill.client.secondName}",
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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DrawerItem(
    title: String,
    selected: String,
    onClick: () -> Unit
){
    var bgColor = Color(247, 247, 245)
    if (selected == title){
        bgColor = Color(220, 210, 242)
    }

    Card(
        shape = RoundedCornerShape(100.dp),
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