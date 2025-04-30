package ro.ccar.kt

import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Address

class Company

class Person(
    var name: String,
    val dayOfBirth: LocalDate,
    var address: Address? = null
) {

    override fun toString(): String {
        return "$name: ${DateTimeFormatter.ISO_DATE.format(dayOfBirth)} ($address)"
    }
}

enum class State {
    On,
    Off
}

class ResilientHandler(
    val maxAttempts: Int = 20,
    val waitBeforeRetry: Duration = Duration.ofMillis(50),
    val maxConcurrentCalls: Int = 25,
    val serviceName: String = "ResilientHandler"
) {

    fun <T> handle(action: () -> T?): T? {
        return action()
    }
}