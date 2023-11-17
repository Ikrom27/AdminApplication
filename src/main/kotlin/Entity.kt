import org.jetbrains.exposed.dao.id.IntIdTable

object Client : IntIdTable() {
    val phone = varchar("phone", 45)
    val mail = varchar("mail", 45)
    val card = varchar("card", 16)
    val name = varchar("name", 45)
    val secondName = varchar("second_name", 45)
    val password = varchar("password", 512)
}
