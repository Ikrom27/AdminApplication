package data

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

object CafeDB {
    init {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/anticafe",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "",
            password = ""
        )
    }

    fun createEvent(nameEvents: String?) {
        transaction {
            EventsTable.insertAndGetId {
                it[EventsTable.nameEvents] = nameEvents
            }
        }
    }

    fun getEvent(id: Int): Events? {
        return transaction {
            EventsTable
                .select { EventsTable.id eq id }
                .singleOrNull()
                ?.toEvents()
        }
    }

    fun updateEvent(id: Int, newNameEvents: String?): Boolean {
        return transaction {
            EventsTable
                .update({ EventsTable.id eq id }) {
                    it[EventsTable.nameEvents] = newNameEvents
                } > 0
        }
    }

    fun deleteEvent(id: Int): Boolean {
        return transaction {
            EventsTable
                .deleteWhere { EventsTable.id eq id } > 0
        }
    }

    private fun ResultRow.toEvents(): Events {
        return Events(
            this[EventsTable.id].value,
            this[EventsTable.nameEvents]
        )
    }
}