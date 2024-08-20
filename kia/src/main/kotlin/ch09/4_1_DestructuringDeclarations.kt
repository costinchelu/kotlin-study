package ch09.DestructuringDeclarations


// for a data class, the compiler generates a componentN function for every property declared in the
// primary constructor
data class Point(
    val x: Int,
    val y: Int
)


fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val city: String,
)

// to ignore a component during destructuring, assign it to _
fun introducePerson(p: Person) {
    val (firstName, _, age) = p
    println("This is $firstName, aged $age.")
}


data class NameComponents(
    val name: String,
    val extension: String,
)


fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}


fun main() {
    val p = Point(10, 20)

    // destructure
    val (a, b) = p
    println(a)      // 10
    println(b)      // 20


    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
    // Oracle -> Java
    // JetBrains -> Kotlin


    val (name, ext) = splitFilename("example.kt")
    println(name)       // example
    println(ext)        // kt

    introducePerson(Person("John", "Doe", 25, "Paris"))
}
