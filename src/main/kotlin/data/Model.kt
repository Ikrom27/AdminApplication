package data

import java.time.LocalDateTime
import java.util.*

data class Client(
    val id: Int,
    val phone: String,
    val mail: String,
    val card: String,
    val name: String,
    val secondName: String,
    val password: String,
    val averageTotal: Double? = null
) {
    override fun toString(): String {
        return "#$id"
    }
}


data class Bill(
    val id: Int,
    val total: Double,
    val date: LocalDateTime,
    val clientId: Int){

    override fun toString(): String {
        return "#$id"
    }
}

data class CoffeeOrder(
    val price: Double,
    val coffeeId: Int,
    val billId: Int,
    val count: Int,
    val title: String? = null)

data class Coffee(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String)

data class BillWithOrders(
    val bill: Bill,
    val client: Client,
    val orderList: List<CoffeeOrder>)

