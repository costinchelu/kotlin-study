package ch06.ex2_1_ExecutingSequenceOperations

// sequence interface - sequence of elements that can be enumerated one by one
// the elements in a sequence are evaluated lazily (no need to create collections to hold intermediate results of the processing
// for sequences all operations are applied on each element sequentially
fun main() {
    listOf(1, 2, 3, 4)
        .asSequence()  /* lazy collection operations - asSequence() = collection extension function */
     .map {
         print("map($it) ")
         it * it
     }
     .filter {
         print("filter($it) ")
         it % 2 == 0
     }
     .toList()  // opposite conversion
}
