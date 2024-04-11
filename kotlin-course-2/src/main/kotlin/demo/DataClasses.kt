package demo

fun dataClasses() {
    val original = Person("John Doe", 30, listOf("123 Main Street", "456 Elm Street"))
    println(original)

    val copy1 = original.copy(name = "Jane Doe")
    val copy2 = original.copy()

    println(original.addresses === copy1.addresses)     // true
    println(original.addresses === copy2.addresses)     // true
    println(original === copy1)                         // false
    println(original === copy2)                         // false
    println(copy1 === copy2)                            // false
    println(original == copy1)                          // false
    println(original == copy2)                          // true (having same content - equals())
    println(copy1 == copy2)                             // false
}

/*
Data classes comes also with:
    - toString
    - equals & hashCode
    - copy
which can be overridden if we need a custom implementation
additionally we have getters/setters, primary constructor
we can't have parameters (without val or val) like in the case of regular classes
 */
data class Person(val name: String, val age: Int, val addresses: List<String>)