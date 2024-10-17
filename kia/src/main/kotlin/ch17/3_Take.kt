package ch17

import ch16.querySensor
import kia2e.coroutines.getTemperatures
import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds


fun main() = runBlocking {
    val temps = getTemperatures()
    temps
        .take(5)
        .collect { log(it) }
}