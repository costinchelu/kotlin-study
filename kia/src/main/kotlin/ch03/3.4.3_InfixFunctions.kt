package ch03.infix

fun main() {

    // using to function (that is also an infix function
    val map1: Map<Int, String> = mapOf(1.to("one"), 2.to("two"), 3.to("three"))

    // using the infix form of to function
    val map2: Map<Int, String> = mapOf(1 to "one", 2 to "two", 3 to "three")

    // to create an infix function we can use the infix keyword:
    // infix fun Any.to(other: Any) = Pair(this, other)

    // destructured declaration
    val (num, name)= 1 to "one"
}

