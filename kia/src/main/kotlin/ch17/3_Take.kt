package ch17

import kia2e.coroutines.getTemperatures
import kia2e.coroutines.log
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

// only takes the first 5 readings (actually the flow will be cancelled after 5 readings)
fun main() = runBlocking {
    val temps = getTemperatures()
    temps
        .take(5)
        .collect { log(it) }
}