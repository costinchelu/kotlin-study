package ch04.ex2_5_ChangingAccessorVisibility


// let's say we need a mutable property, and we don't want to allow the setter to be accessed by the clients
// because it is a var, an implicit setter is available
// we can set the setter as private and provide a function that will mutate the counter
// and the counter can still be accessed through the getter
class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}
