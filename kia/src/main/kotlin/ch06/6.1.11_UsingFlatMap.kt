package ch06.ex1_11_UsingFlatMap


class Book(val title: String, val authors: List<String>)

val library = listOf(
    Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
    Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
    Book("The Three-Body Problem", listOf("Liu"))
)


fun main() {
    val authors = library.map { it.authors }
    println(authors) // [[Isakova, Elizarov, Aigner, Jemerov], [Eckel, Isakova], [Liu]]
    val flatAuthors = library.flatMap { it.authors }
    println(flatAuthors)        // [Isakova, Elizarov, Aigner, Jemerov, Eckel, Isakova, Liu]
    println(authors.flatten())  // [Isakova, Elizarov, Aigner, Jemerov, Eckel, Isakova, Liu]
}