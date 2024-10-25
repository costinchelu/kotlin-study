package ch18

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// moving the try catch block inside the launch block shoudl work
fun main(): Unit = runBlocking {
    launch {
        try {
            throw UnsupportedOperationException("Ouch!")
        } catch (u: UnsupportedOperationException) {
            println("Handled $u")
        }
    }
}