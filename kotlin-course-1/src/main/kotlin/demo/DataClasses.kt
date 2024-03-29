package demo

data class Person(val name: String, val age: Int, val addresses: List<String>)

fun main(args: Array<String>) {
    val original = Person("John Doe", 30, listOf("123 Main Street", "456 Elm Street"))

    println(original)

    val copy1 = original.copy(name = "Jane Doe")
    val copy2 = original.copy()

    println(original.addresses === copy1.addresses)  // true
    println(original.addresses === copy2.addresses)  // true
}