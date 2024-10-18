package ch17

import kia2e.coroutines.getTemperatures
import kia2e.coroutines.log
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val temps = getTemperatures()
    temps
        .take(5)
        .onEmpty { log("Flow is empty") }
        .onStart { log("Flow started") }
        .onEach { log("Read > $it") }
        .onCompletion { cause ->
            if (cause != null) {
                log("An error occurred! $cause")
            } else {
                log("Completed!")
            }
        }
        .collect { log("Collected >> $it") }
}