package ch16

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// keeping track of some value that may change over time
//  state flow is a special case of a shared flow - keep track of state changes over time
class ViewCounter {

    // we also provide an initial value
    private val _counter = MutableStateFlow(0)

    val counter = _counter.asStateFlow()

    // update make atomic updates to the value of the state flow
    fun increment() {
        _counter.update { it + 1 }
    }
}

fun main() {
    val vc = ViewCounter()
    runBlocking(Dispatchers.Default) {
        repeat(10_000) {
            launch { vc.increment() }
        }
    }

    // we can access the current state represented by the mutable state flow via its value property (safe read)
    println(vc.counter.value)
    // 10000
}
/*
classic incrementation (value++) are not atomic
A code like this - concurrent access to incrementation will not return what we expect:


class ViewCounter {

    private val _counter = MutableStateFlow(0)

    val counter = _counter.asStateFlow()

    fun increment() {
        _counter.value++
    }
}

fun main() {
    val vc = ViewCounter()
    runBlocking(Dispatchers.Default) {
        repeat(10_000) {
            launch { vc.increment() }
        }
    }
    println(vc.counter.value)
    // 4185
}

 */