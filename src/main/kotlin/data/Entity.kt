package data


import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.jodatime.datetime

object AnticafeTable : IntIdTable(name = "anticafe") {
    val adressAnticafe = varchar("adress_anticafe", 20).nullable()
}

object BookingTable : IntIdTable(name = "booking") {
    val numberOfGuests = integer("number_of_guests").nullable()
    val idAnticafe = integer("id_anticafe").nullable()
    val idTreaty = integer("id_treaty").nullable()
    val idClient = blob("id_client").nullable()
}

object ClientTable : IntIdTable(name = "client") {
    val idClient = blob("id_client")
    val telNumber = integer("tel_number").nullable()
    val name = varchar("name", 20).nullable()
    val dataBirthday = integer("data_birthday").nullable()
    val mail = varchar("mail", 20).nullable()
}

object EventsTable : IntIdTable(name = "events") {
    val nameEvents = varchar("name_events", 20).nullable()
}

object NewsTable : IntIdTable(name = "news") {
    val date = datetime("date").nullable()
    val headerTheme = varchar("header_theme", 20).nullable()
    val idWorker = char("id_worker", 18)
    val idNews = integer("id_news")
}

object OrganizersTable : IntIdTable(name = "organizers") {
    val telNumber = integer("tel_number").nullable()
    val mail = varchar("mail", 20).nullable()
    val name = varchar("name", 20).nullable()
    val idOrganizers = integer("id_organizers")
    val dateBirthday = integer("date_birthday").nullable()
}

object PaymentTable : IntIdTable(name = "payment") {
    val sum = integer("sum").nullable()
    val idBooking = integer("id_booking")
    val status = char("status", 18).nullable()
}

object ReviewTable : IntIdTable(name = "review") {
    val author = varchar("author", 20).nullable()
    val idReview = char("id_review", 18)
    val idNews = integer("id_news")
}

object TreatyTable : IntIdTable(name = "treaty") {
    val idTreaty = integer("id_treaty")
    val dateOfSigning = datetime("date_of_signing").nullable()
    val expirationDate = datetime("expiration_date").nullable()
    val idOrganizers = integer("id_organizers")
    val idWorker = char("id_worker", 18)
    val idEvents = integer("id_events").nullable()
}

object WorkerTable : IntIdTable(name = "worker") {
    val telNumber = integer("tel_number").nullable()
    val mail = varchar("mail", 20).nullable()
    val name = varchar("name", 20).nullable()
    val idWorker = char("id_worker", 18)
    val seniority = integer("seniority").nullable()
    val skill = varchar("skill", 20).nullable()
}
