package ch16

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

// each of the values are available after 1 second, but only after the function finish execution
suspend fun createValues(): List<Int> {
    return buildList {
        add(1)
        delay(1.seconds)
        add(2)
        delay(1.seconds)
        add(3)
        delay(1.seconds)
    }
}

// with flows, each value is available when inserted into the Flow and doesn't need to wait
// for the complete execution of the function
// design inspired from reactive streams
fun createValuesFlow(): Flow<Int> {
    return flow {
        emit(1)
        delay(1000.milliseconds)
        emit(2)
        delay(1000.milliseconds)
        emit(3)
        delay(1000.milliseconds)
    }
}

fun main() {

    runBlocking {
        val list = createValues()
        list.forEach { log(it) }
    }



    runBlocking {
        val myFlowOfValues = createValuesFlow()
        myFlowOfValues.collect { log(it) }
    }
}

