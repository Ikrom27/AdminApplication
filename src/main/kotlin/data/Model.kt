package data

import java.time.LocalDateTime
import java.util.*


data class Anticafe(
    val id: Int,
    val adressAnticafe: String?
)

data class Booking(
    val id: Int,
    val numberOfGuests: Int?,
    val idAnticafe: Int?,
    val idTreaty: Int?,
    val idClient: ByteArray?
)

data class Client(
    val idClient: ByteArray,
    val telNumber: Int?,
    val name: String?,
    val dataBirthday: Int?,
    val mail: String?
)

data class Events(
    val id: Int,
    val nameEvents: String?
)

data class News(
    val date: java.sql.Date?,
    val headerTheme: String?,
    val idWorker: String,
    val idNews: Int
)

data class Organizers(
    val telNumber: Int?,
    val mail: String?,
    val name: String?,
    val idOrganizers: Int,
    val dateBirthday: Int?
)

data class Payment(
    val sum: Int?,
    val idBooking: Int,
    val status: String?
)

data class Review(
    val author: String?,
    val idReview: String,
    val idNews: Int
)

data class Treaty(
    val idTreaty: Int,
    val dateOfSigning: java.sql.Date?,
    val expirationDate: java.sql.Date?,
    val idOrganizers: Int,
    val idWorker: String,
    val idEvents: Int?
)

data class Worker(
    val telNumber: Int?,
    val mail: String?,
    val name: String?,
    val idWorker: String,
    val seniority: Int?,
    val skill: String?
)
