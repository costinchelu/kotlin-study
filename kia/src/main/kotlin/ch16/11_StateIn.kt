package ch16

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

// stateIn converts a col flow into a hot state flow
// it doesn't provide any starting strategies - starts the flow in the given coroutine scope and keeps providing
// its latest value to its subscribers via the value property until coroutine scope is cancelled
fun main() {
    val temps = getTemperatures()
    runBlocking {
        val tempState = temps.stateIn(this)
        println(tempState.value)
        delay(800.milliseconds)
        println(tempState.value)
    }
}
// 18
// -1