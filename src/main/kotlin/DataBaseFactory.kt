import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


object DatabaseFactory {
    fun init() {
        Database.connect(
            url = "jdbc:mysql://192.168.1.53:3306/coffee_house",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "07601367"
        )

        transaction {
            addLogger(StdOutSqlLogger)
            val result = Client.selectAll()
            println(result.first()[Client.name])
            for (row in result) {
                println(
                    "Name: ${row[Client.name]}, " + "Second Name: ${row[Client.secondName]}"
                )
            }
        }
    }
}