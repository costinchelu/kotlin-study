package ch16_State_Flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

// example with a state flow
class Broadcaster {

    private val _messages = MutableStateFlow<List<String>>(emptyList())

    val messages = _messages.asStateFlow()

    fun beginBroadcasting(scope: CoroutineScope) {
        scope.launch {
            _messages.update { it + "Hello!" }
            _messages.update { it + "Hi!" }
            _messages.update { it + "Hola!" }
        }
    }
}

fun main() = runBlocking {
    val broadcaster = Broadcaster()
    broadcaster.beginBroadcasting(this)
    delay(200.milliseconds)
    println(broadcaster.messages.value)
}
/*
            COLD FLOW                                           HOT FLOW
    Inert by default (triggered by the collector)       Active by default
    Has a collector                                     Has multiple subscribers
    Collector gets all emissions                        Subscribers get emissions from the start of subscription
    Potentially completes                               Doesn't complete
    Emissions happen from a single coroutine            Emissions can happen from arbitrary coroutines
    (unless channelFlow is used)

As a rule of thumb:
    - functions that provide a service (network req, reading DB) are declared using cold flows
    - other classes and functions that use these flows can either collect them directly or convert them into state flows and shared flows

 */