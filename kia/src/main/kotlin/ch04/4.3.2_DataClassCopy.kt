package ch04.ex3_2_1_DataClassCopy

data class Customer(val name: String, val postalCode: Int)

fun main() {
    val bob = Customer("Bob", 973293)

    // bob is immutable and so we have a utility method that gets all of bob's property values and changes
    // some of them if needed. The result is a completely different immutable object
    println(bob.copy(postalCode = 382555))
}
