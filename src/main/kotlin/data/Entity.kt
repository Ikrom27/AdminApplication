package data

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.alias
import org.jetbrains.exposed.sql.javatime.datetime

object ClientEntity : IntIdTable(name = "client") {
    val phone = varchar("phone", 45)
    val mail = varchar("mail", 45)
    val card = varchar("card", 16)
    val name = varchar("name", 45)
    val secondName = varchar("second_name", 45)
    val password = varchar("password", 512)
}

object BillEntity : IntIdTable(name = "bill") {
    val total = double("total")
    val date = datetime("date")
    val clientId = integer("client_client_id")
}

object CoffeeEntity : IntIdTable(name = "coffee") {
    val name = varchar("name", 45)
    val price = double("price")
    val description = varchar("description", 512)
}

object CoffeeOrderEntity : Table(name = "coffee_order") {
    val price = double("price")
    val coffeeId = integer("coffee_coffee_id").references(CoffeeEntity.id)
    val billId = integer("bill_bill_id").references(BillEntity.id)
    val count = integer("count")
}