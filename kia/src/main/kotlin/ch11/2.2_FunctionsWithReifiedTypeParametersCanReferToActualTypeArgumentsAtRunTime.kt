package ch11.ex2_1_FunctionsWithReifiedTypeParametersCanReferToActualTypeArgumentsAtRunTime

inline fun <reified T> isA(value: Any) = value is T

fun main() {
    println(isA<String>("abc"))                         // true
    println(isA<String>(123))                           // false


    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())           // [one, three]
}
