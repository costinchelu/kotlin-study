package ch11.FunctionsAndPropertiesThatWorkWithGenericTypes

val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))              // [a, b, c]
    println(letters.slice(10..13))                  // [k, l, m, n]


    println(listOf(1, 2, 3, 4).penultimate)                      // 3
}
