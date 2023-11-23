package ui.components

import CoffeeTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Client


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientCardItem(client: Client, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
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

            Text(
                text = "client.mail",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 12.sp
                )
            )
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