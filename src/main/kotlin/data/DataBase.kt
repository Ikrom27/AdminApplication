package data

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import data.BillEntity


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

    fun getClients(): List<Client> {
        val result = mutableListOf<Client>()
        transaction {
            ClientEntity.selectAll().forEach {
                result.add(
                    Client(
                        it[ClientEntity.id].value,
                        it[ClientEntity.phone],
                        it[ClientEntity.mail],
                        it[ClientEntity.card],
                        it[ClientEntity.name],
                        it[ClientEntity.secondName],
                        it[ClientEntity.password]
                    )
                )
            }
        }
        return result
    }


    fun getBills(): List<Bill>{
        val result = mutableListOf<Bill>()
        transaction {
            BillEntity.selectAll().forEach {
                result.add(
                    Bill(
                        it[BillEntity.id].value,
                        it[BillEntity.total],
                        it[BillEntity.date],
                        it[BillEntity.clientId]
                    )
                )
                println(it[BillEntity.total])
            }
        }
        return result
    }
}