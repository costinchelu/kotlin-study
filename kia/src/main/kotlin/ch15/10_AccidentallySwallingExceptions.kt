package ch15.SwallingExceptions

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

suspend fun doWork() {
    delay(500.milliseconds)
    throw UnsupportedOperationException("Didn't work!")
}

// here by catching any exception we will prevent cancellation (withTimeoutOrNull will request cancellation after 2 seconds
fun main() {
    runBlocking {
        withTimeoutOrNull(2.seconds) {
            while (true) {
                try {
                    doWork()
                } catch (e: Exception) {
                    println("Oops: ${e.message}")
                }
            }
        }
    }
}
// it will not terminate because of that
// But catching only UnsupportedOperationException will let the program finish
// also by rethrowing CancellationException we can let the program finish
// IllegalStateException, RuntimeException, Exception, and Throwable will also prevent cancellation
