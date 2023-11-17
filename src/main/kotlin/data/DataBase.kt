package data

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction


object CoffeeHouseDB {

    init {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/coffee_house",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "07601367"
        )
    }

    fun addClient(client: Client){
        transaction {
            ClientEntity.insertAndGetId {
                it[phone] = client.phone
                it[mail] = client.mail
                it[card] = client.card
                it[name] = client.name
                it[secondName] = client.secondName
                it[password] = client.password
            }
        }
    }
}