package ch16

import kia2e.coroutines.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

// hot flow
// shared flows are used for broadcasting values

// shared flows are typically declared in a container class
class RadioStation {

    // mutable shared flow - emit values (private)
    private val _messageFlow: MutableSharedFlow<Int> = MutableSharedFlow()

    // immutable shared flow - subscribe to emissions (collect) (public)
    val messageFlow: SharedFlow<Int> = _messageFlow.asSharedFlow()

    // emitting flow
    fun beginBroadcasting(scope: CoroutineScope) {
        scope.launch {
            while (true) {
                delay(250.milliseconds)
                val number = Random.nextInt(0..10)
                log("Emitting $number!")
                _messageFlow.emit(number)
            }
        }
    }
}

fun main(): Unit = runBlocking {
    val radioStation = RadioStation()
    radioStation.beginBroadcasting(this)

    // collect the flow (lambda will be executed whenever a value is emitted)
    launch {
        radioStation.messageFlow.collect { log("A collecting $it!") }
    }

    // if we delay the collection, then all values that were emitted before will not be received
    // we can use the replay parameter if we need to receive the previously emitted values:
//    private val _messageFlow = MutableSharedFlow<Int>(replay = 5)
    delay(600.milliseconds)

    // because shared flows operate in a broadcast fashion, we can add additional subscribers
    launch {
        radioStation.messageFlow.collect { log("B collecting $it!") }
    }
}