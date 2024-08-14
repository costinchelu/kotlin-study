package ch08.ex1_7_NothingType

// Nothing type - this function never returns
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}


interface Processor<T> {
    fun process(): T
}

// Unit can be used as a type argument
// when we have a function that returns a generic parameter, we can use Unit as a return type
// (if we don't need a specific type) so we don't need to write the return statement
class NoResultProcessor: Processor<Unit> {
    override fun process() {
        println("Return Unit (void)")
    }
}

fun main() {
    val someValue: Any = "test Any (Object)"
    println(someValue)


    val processor = NoResultProcessor()
    processor.process()


    fail("Error occurred")
}
