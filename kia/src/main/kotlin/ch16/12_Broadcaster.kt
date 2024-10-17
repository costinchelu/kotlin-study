package ch16_Shared_Flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/*
As a conclusion (about the hot flows):

state flows - lower complexity - they only represent a single value
shared flows - added complexity - we have to make sure subscribers are present at the time they are expected to receive emissions

 */

// example with the shared flow
class Broadcaster {

    private val _messages = MutableSharedFlow<String>()

    val messages = _messages.asSharedFlow()

    fun beginBroadcasting(scope: CoroutineScope) {
        scope.launch {
            _messages.emit("Hello!")
            _messages.emit("Hi!")
            _messages.emit("Hola!")
        }
    }
}

fun main(): Unit = runBlocking {
    val broadcaster = Broadcaster()
    broadcaster.beginBroadcasting(this)
    delay(200.milliseconds)
    // because the subscribers only appears sometime after the messages were broadcast, it won't receive any messages
    broadcaster.messages.collect { println("Message: $it") }
    // rather than emitting individual messages, a state flow would store the entire message history as a list
    // so that subscribers can easily access all prior messages
}