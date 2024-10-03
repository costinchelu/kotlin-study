package ch14

import kia2e.coroutines.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// by choosing a dispatcher we can configure the execution of a coroutine to a specific thread
// or dispatch it to a thread pool
fun main() {
    runBlocking {
        log("Doing some work")
        launch(Dispatchers.Default) {
            log("Doing some background work")
        }
    }
}