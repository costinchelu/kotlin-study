package ro.ccar.kt

import java.util.*

open class Base4K(val name: String) {

    // instance initializer block
    init {
        println("Initializing Base")
    }

    // property with initializer
    open val size: Int = name.length.also { println("Initializing size in Base: $it characters") }
}

// pass to the base class constructor, a modified value of the name property
class Derived4K(
    name: String,
    private val lastName: String
) : Base4K(
    name
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        .also { println("Argument for Base: $it") }
) {

    init {
        println("Initializing Derived")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

fun main() {
    Derived4K("john", "Doe")
}