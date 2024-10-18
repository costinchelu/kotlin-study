package ch17

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

// operations on flows behave as we would expect on the elements of a flow rather than a sequence or a collection
fun main() {
//    val names = flow {
//        emit("Jo")
//        emit("May")
//        emit("Sue")
//    }
    val names = flowOf("Jo", "May", "Sue")

    // intermediate operation
    // emits one transformation operation for each element
    val uppercasedNames = names.map {
        it.uppercase()
    }

    // intermediate operation
    // emits one or more elements for each input element (enhanced map)
    val transformNames: Flow<String> = names.transform {
        emit(it)
        emit(it.uppercase())
        emit(it.lowercase())
    }

    // collect is a terminal operator
    runBlocking {
        uppercasedNames.collect { print("$it ") }
        println()
        transformNames.collect { print("$it ") }
    }
    // JO MAY SUE
    // Jo JO jo May MAY may Sue SUE sue
}