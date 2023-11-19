package data

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
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

    fun updateClient(client: Client) {
        transaction {
            ClientEntity.update({ ClientEntity.id eq client.id }) {
                it[phone] = client.phone
                it[mail] = client.mail
                it[card] = client.card
                it[name] = client.name
                it[secondName] = client.secondName
                it[password] = client.password
            }
        }
    }

    fun deleteClient(clientId: Int) {
        transaction {
            ClientEntity.deleteWhere { ClientEntity.id eq clientId }
        }
    }

    fun getClients(): List<Client> {
        val result = mutableListOf<Client>()
        transaction {
            ClientEntity.selectAll().forEach {
                var averageTotal = 0.0

                transaction {
                    val query = "SELECT MIDDLE_TOTAL(${it[ClientEntity.id].value}) as result"
                    exec(query) { result ->
                        if (result.next()) {
                            averageTotal = result.getDouble("result")
                        }
                    }
                }
                result.add(
                    Client(
                        it[ClientEntity.id].value,
                        it[ClientEntity.phone],
                        it[ClientEntity.mail],
                        it[ClientEntity.card],
                        it[ClientEntity.name],
                        it[ClientEntity.secondName],
                        it[ClientEntity.password],
                        averageTotal
                    )
                )
            }
        }
        return result
    }

    fun getAllBillsWithOrders(toSort: Boolean = false): List<BillWithOrders> {
        return transaction {
            addLogger(StdOutSqlLogger)
            BillEntity
                .join(ClientEntity, JoinType.INNER, additionalConstraint = { BillEntity.clientId eq ClientEntity.id })
                .selectAll()
                .also {
                    if (toSort){
                        it.orderBy(BillEntity.total, SortOrder.DESC)
                    }
                }
                .map { row ->
                    val bill = Bill(
                        id = row[BillEntity.id].value,
                        total = row[BillEntity.total],
                        date = row[BillEntity.date],
                        clientId = row[BillEntity.clientId]
                    )

                    val client = Client(
                        id = row[ClientEntity.id].value,
                        phone = row[ClientEntity.phone],
                        mail = row[ClientEntity.mail],
                        card = row[ClientEntity.card],
                        name = row[ClientEntity.name],
                        secondName = row[ClientEntity.secondName],
                        password = row[ClientEntity.password]
                    )

                    val coffeeList = CoffeeOrderEntity
                        .join(CoffeeEntity, JoinType.INNER, additionalConstraint = { CoffeeOrderEntity.coffeeId eq CoffeeEntity.id })
                        .select { CoffeeOrderEntity.billId eq bill.id }
                        .map {
                            CoffeeOrder(
                                price = it[CoffeeOrderEntity.price],
                                coffeeId = it[CoffeeOrderEntity.coffeeId],
                                billId = it[CoffeeOrderEntity.billId],
                                count = it[CoffeeOrderEntity.count],
                                title = it[CoffeeEntity.name]
                            )
                        }

                    BillWithOrders(bill, client, coffeeList)
                }
        }
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