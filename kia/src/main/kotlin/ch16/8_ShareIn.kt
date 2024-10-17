package ch16

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

fun querySensor(): Int = Random.nextInt(-10..30)

// this function returns a cold flow
fun getTemperatures(): Flow<Int> {
    return flow {
        while (true) {
            emit(querySensor())
            delay(500.milliseconds)
        }
    }
}

fun celsiusToFahrenheit(celsius: Int) = celsius * 9.0 / 5.0 + 32.0

// transforming a cold flow to a shared (hot) flow using shareIn
fun main() {
    val temps = getTemperatures()
    runBlocking {
        val sharedTemps = temps.shareIn(this, SharingStarted.Lazily)

// with a normal cold flow, each collector would cause the sensor to be queried independently
//        launch {
//            temps.collect { log("$it Celsius") }
//        }
//        launch {
//            temps.collect { log("${celsiusToFahrenheit(it)} Fahrenheit") }
//        }

        // in this case (communicating with an external source) it would be better to use a shared flow
        // in this case we are receiving only one reading and both collections are sharing the same flow
        launch {
            sharedTemps.collect { log("$it Celsius") }
        }
        launch {
            sharedTemps.collect { log("${celsiusToFahrenheit(it)} Fahrenheit") }
        }
    }
}
