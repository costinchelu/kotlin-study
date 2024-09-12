package ch11.ex6_2_StarProjection


fun <T> printFirstV1(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

// * means elements of a specific type we don't know
// if you don't know the type, in this case you can't put anything in the list, but you can take from it
fun printFirstV2(list: List<*>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

fun main() {
    printFirstV1(listOf("Sveta", "Seb", "Dima", "Roman"))             // Sveta
}