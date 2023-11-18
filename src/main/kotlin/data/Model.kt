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
)

data class Bill(
    val id: Int,
    val total: Double,
    val date: LocalDateTime,
    val clientId: Int)